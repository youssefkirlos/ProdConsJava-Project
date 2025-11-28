package prodcons.v5;

public class Consumer extends Thread {
	
	private final IProdConsBuffer buffer;
    private final int consTime;
    private final int kConsume;
    private static int totmsgC = 0;

    public Consumer(IProdConsBuffer buffer, int consTime,int kConsume) {
        this.buffer = buffer;
        this.consTime = consTime;
        this.kConsume = kConsume;
    }
    

    @Override
    public void run() {
        try {
            while (true) {
            	
            	// TEST : Objectif 5 
            	 int k = kConsume; 
                 Message[] msgs = buffer.get(k);
                 totmsgC+= k ;

                 System.out.println("Consumer " + getId() +
                         " consumed " + k + " messages ");

                 for (Message m : msgs) {
                     System.out.println("   -> " + m);
                 }
               
                
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
