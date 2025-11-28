package prodcons.v2;

public class Consumer extends Thread {
	
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
            while (true) {
                Message m = buffer.get();
                
                
                // Objectif 2 (Terminaison)
                if (m == null) {
                    System.out.println("Consumer " + getId() + " Stops.");
                    return; 
                }else {
                	totmsgC++;
                }
                
                
                // TEST : les messages consommés
                System.out.println("Consumer " + getId() + " consumed message " + m);
                
                
                
                sleep(consTime);
            }
        } catch (InterruptedException e) {
        	 //e.printStackTrace();
        }
    }
    
    public static int getTotmsgC() {
    	return totmsgC ;
    }
}
