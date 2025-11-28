package prodcons.v7;

import java.util.concurrent.Semaphore;

// On utilise la version Semaphore (OBJ 3) 
public class ProdConsBuffer implements IProdConsBuffer {
	
	private final Task[] buffer;
    private final int bufSz;
    //private int arrivalCounter = 0;

    private int in = 0;
    private int out = 0;
    private int totmsg = 0;
    private int nfull = 0;
    
    private final Semaphore notFull;   
    private final Semaphore notEmpty;  
    private final Semaphore mutex;     
    
    public ProdConsBuffer(int bufSz) {  
        this.bufSz = bufSz;
        this.buffer = new Task[bufSz];
        
 
        this.notFull = new Semaphore(bufSz, true);
        this.notEmpty = new Semaphore(0, true);
        this.mutex = new Semaphore(1, true);
    }
    

    @Override
    public void put(Task t) throws InterruptedException {
    	
    	if (notFull.availablePermits() == 0) {
            System.out.println("TEST : Producer " + t.getProducerId() + " IS WAITING (buffer full)");
        }
    	
        notFull.acquire();
        
        mutex.acquire();

        buffer[in] = t;
        System.out.println("[PUT] index=" + in + "  -> " + t);
        nfull++;
        in = (in + 1) % bufSz;
        totmsg++;

        mutex.release();
        notEmpty.release();
   
    }
    
    
    
    @Override
    public Task get() throws InterruptedException {
    	
        notEmpty.acquire();  
        mutex.acquire();
        
        

        Task t = buffer[out];
        System.out.println("[GET] index=" + out + "  -> " + t);
        out = (out + 1) % bufSz;
        nfull--;
 
        mutex.release();
        notFull.release();

        return t;
	}

	@Override
	public int nmsg() {
		return nfull;
	}
	
	
	@Override
	public int totmsg() {
		return totmsg ;
	}


}
