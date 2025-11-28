package prodcons.v7;

import java.util.Random;

public class Producer extends Thread {
	
	private final TaskExecutor executor;
    private final int minProd, maxProd;
    private final int prodTime;

    public Producer(TaskExecutor executor, int minProd, int maxProd, int prodTime) {
        this.executor = executor;
    	this.minProd = minProd;
        this.maxProd = maxProd;
        this.prodTime = prodTime;
    }
    
    @Override
    public void run() {
        Random r = new Random();
        int count = r.nextInt(maxProd - minProd + 1) + minProd;

        for (int i = 0; i < count; i++) {
       
            int id = i;
            
            try {
            	System.out.println("Producer " + getId() + " produced Task " + i); 
            	sleep(prodTime);
                executor.executeTask(() -> {
                    System.out.println("Executing task " + id + " by producer " + getId());
                },i);

   
            } catch (InterruptedException e) {}
        }
    }

}
