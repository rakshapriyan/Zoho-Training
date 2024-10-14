package task.threads;

import java.util.logging.Logger;

public class RunnableThread implements Runnable {
    private static final Logger logger = Logger.getLogger(RunnableThread.class.getName());
    private long sleepTime = -1;
    private volatile boolean running = true;

    public RunnableThread(long sleepTime) {
        this.sleepTime = sleepTime;
    }

    public RunnableThread() {
		// TODO Auto-generated constructor stub
	}

	@Override
    public void run() {
        Thread currentThread = Thread.currentThread();
        logger.info("Starting thread: " + currentThread.getName());

        while (running) {
            try {
                if (sleepTime != -1) {
                    logger.info("Going to Sleep for " + sleepTime + " ms: " + currentThread.getName());
                    Thread.sleep(sleepTime);
                } else {
                    Thread.sleep(60000);
                }
            } catch (InterruptedException e) {
                logger.severe("Error: Cannot put thread to sleep " + currentThread.getName() + " " + e.getMessage());
            }
            logger.info("After sleeping: " + currentThread.getName());
            printDetails();
        }

        logger.info("Stopping thread: " + currentThread.getName());
    }

    public void printDetails() {
        Thread currentThread = Thread.currentThread();
        logger.info("Thread Name: " + currentThread.getName());
        logger.info("Thread Priority: " + currentThread.getPriority());
        logger.info("Thread State: " + currentThread.getState());
    }

    public void stopRunning() {
        running = false;
    }
}
