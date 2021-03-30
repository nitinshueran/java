package com.shu.nitin.threads;

import java.util.List;

public class SleepDemo {

	public static void main(String[] args) {

		Runnable slideRotater = () -> {
			for (int i = 1; i <= 10; i++) {
				System.out.println("Displaying content of Slide: " + i);
			}
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				System.out.println("I got interrupted");
			}
		};
		Thread t = new Thread(slideRotater);
		t.start();

		t.interrupt();
		System.out.println("End of main thread");
	}
}

 class MultiExecutor {

    // Add any necessary member variables here
    private List<Runnable> tasks;
    /* 
     * @param tasks to executed concurrently
     */
    public MultiExecutor(List<Runnable> tasks) {
        // Complete your code here
        this.tasks = tasks;
    }

    /**
     * Starts and executes all the tasks concurrently
     */
    public void executeAll() {
        // complete your code here
        if(null != tasks && !tasks.isEmpty()){
            for(Runnable r: tasks){
                r.run();
            }
        }
    }
}
 
 
