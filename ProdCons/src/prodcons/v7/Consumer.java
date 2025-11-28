package prodcons.v7;


public class Consumer extends Thread{
	private final IProdConsBuffer buffer;
    private final int consTime;
    private static int totmsgC = 0;

    public Consumer(IProdConsBuffer buffer, int consTime) {
        this.buffer = buffer;
        this.consTime = consTime;
    }
    
    @Override
    public void run() {
        try {
            Task t = buffer.get();   
            t.run();   
            totmsgC++;
            // TEST : les messages consommés
            System.out.println("Consumer " + getId() + " consumed Task " + t);
            
            
            
            sleep(consTime);
        } catch (InterruptedException e) {}

    }
    
    public static int getTotmsgC() {
    	return totmsgC ;
    }
}
