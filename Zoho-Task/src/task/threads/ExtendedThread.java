package task.threads;

import java.util.logging.Logger;

public class ExtendedThread extends Thread {
    private static final Logger logger = Logger.getLogger(ExtendedThread.class.getName());
    private long sleepTime = -1;
    private volatile boolean running = true;

    public ExtendedThread(long sleepTime) {
        this.sleepTime = sleepTime;
    }

    public ExtendedThread() {
		// TODO Auto-generated constructor stub
	}

	@Override
    public void run() {
        logger.info("Starting thread: " + this.getName());

        while (running) {
            try {
                if (sleepTime != -1) {
                    logger.info("Going to Sleep for " + sleepTime + " ms: " + this.getName());
                    Thread.sleep(sleepTime);
                } else {
                    Thread.sleep(60000);
                }
            } catch (InterruptedException e) {
                logger.severe("Error: Cannot put thread to sleep " + this.getName() + " " + e.getMessage());
            }
            logger.info("After sleeping: " + this.getName());
            printDetails();
        }

        logger.info("Stopping thread: " + this.getName());
    }

    public void printDetails() {
        logger.info("Thread Name: " + this.getName());
        logger.info("Thread Priority: " + this.getPriority());
        logger.info("Thread State: " + this.getState());
    }

    public void stopRunning() {
        running = false;
    }
}
