package task.threads;

import java.util.logging.Level;
import java.util.logging.Logger;


public class ExtendedThread extends Thread {
    private static final Logger logger = Logger.getLogger(ExtendedThread.class.getName());
    private int sleepTime = -1;
    
    public ExtendedThread(int sleeepTime) {
    	this.sleepTime = sleeepTime;
    }
    
    
    public ExtendedThread() {
    	
    }
    
    @Override
    public void run() {
    	logger.log(Level.INFO, "Going to Sleep: ", this.getName());
    	try {
    		if(sleepTime!=-1) {
    			this.sleep(sleepTime);
    		}
    		else {
    			Thread.sleep(60000);
    			
    		}
		} catch (InterruptedException e) {
			logger.log(Level.SEVERE, "Error: Cannot put into sleep"+e.getStackTrace());
		}
        logger.log(Level.INFO, "After sleeping: ", this.getName());
        printDetails();
    }
    
    
    public void printDetails() {
    	logger.log(Level.INFO, "Thread Name: ", this.getName());
        logger.log(Level.INFO, "Thread Priority: ", this.getPriority());
        logger.log(Level.INFO, "Thread State: ", this.getState());
    }
}