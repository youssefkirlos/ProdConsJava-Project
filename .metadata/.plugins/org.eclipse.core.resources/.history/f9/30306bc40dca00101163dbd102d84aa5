package prodcons.v3;

import java.util.concurrent.Semaphore;

public class ProdConsBuffer implements IProdConsBuffer {
	
	private final Message[] buffer;
    private final int bufSz;
    private int arrivalCounter = 0;

    private int in = 0;
    private int out = 0;
    private int totmsg = 0;
    private int nfull = 0;
    
    private final Semaphore notFull;   
    private final Semaphore notEmpty;  
    private final Semaphore mutex;     
    
    public ProdConsBuffer(int bufSz) {  
        this.bufSz = bufSz;
        this.buffer = new Message[bufSz];
        
        // Objectif 3
        this.notFull = new Semaphore(bufSz, true);
        this.notEmpty = new Semaphore(0, true);
        this.mutex = new Semaphore(1, true);
    }
    

    @Override
    public void put(Message m) throws InterruptedException {
    	
    	if (notFull.availablePermits() == 0) {
            System.out.println("TEST : Producer " + m.getProducerId() + " IS WAITING (buffer full)");
        }
    	
        notFull.acquire();
        
        mutex.acquire();

        buffer[in] = m;
        m.setArrivalOrder(arrivalCounter++);
        nfull++;
        in = (in + 1) % bufSz;
        totmsg++;

        mutex.release();
        notEmpty.release();
   
    }
    
    
    
    @Override
    public Message get() throws InterruptedException {
    	
        notEmpty.acquire();  
        mutex.acquire();
        
        

        Message m = buffer[out];
        out = (out + 1) % bufSz;
        nfull--;
 
        mutex.release();
        notFull.release();

        return m;
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
