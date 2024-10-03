package task.threads;

import java.util.logging.Level;
import java.util.logging.Logger;

public class RunnableThread implements Runnable {
    private static final Logger logger = Logger.getLogger(RunnableThread.class.getName());
    private int sleepTime = -1;
    @Override
    public void run() {
    	Thread currentThread = Thread.currentThread();
    	logger.log(Level.INFO, "Going to Sleep: ", currentThread.getName());
    	try {
    		if(sleepTime!=-1) {
    			Thread.sleep(sleepTime);
    		}
    		else {
    			Thread.sleep(60000);
    			
    		}
		} catch (InterruptedException e) {
			logger.log(Level.SEVERE, "Error: Cannot put into sleep"+e.getStackTrace());
		}
        logger.log(Level.INFO, "After sleeping: ", currentThread.getName());
        printDetails();
    }
    public void printDetails() {
    	Thread currentThread = Thread.currentThread();
        logger.log(Level.INFO, "Thread name: ", currentThread.getName());
        logger.log(Level.INFO, "Thread Priority: ", currentThread.getPriority());
        logger.log(Level.INFO, "Thread State: ", currentThread.getState());
    }
}
