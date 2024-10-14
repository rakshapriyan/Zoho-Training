package task.threads;

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadInfo;
import java.lang.management.ThreadMXBean;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ThreadRunner {
    private static Scanner sc = new Scanner(System.in);
    private static final Logger logger = Logger.getLogger(ThreadRunner.class.getName());

    public static void main(String[] args) {
        ThreadRunner threadRunner = new ThreadRunner();
        int choice = Integer.parseInt(sc.nextLine());
        
        switch (choice) {
            case 1:
                threadRunner.printExtendedThread();
                break;
            case 2:
                threadRunner.printRunnableThread();
                break;
            case 3:
                threadRunner.printBeforeAndAfterStarting();
                break;
            case 4:
                threadRunner.printWithSleep();
                break;
            case 5:
                threadRunner.printWithCustomSleep();
                break;
            default:
                logger.severe("Invalid choice: " + choice);
                break;
        }
    }

    private void printThreadData(Thread thread) {
        thread.run();
    }

    private void printExtendedThread() {
        ExtendedThread extendedThread = new ExtendedThread();
        extendedThread.start();
        printThreadData(extendedThread);
    }

    private void printRunnableThread() {
        RunnableThread runnableThread = new RunnableThread();
        Thread thread = new Thread(runnableThread);
        thread.start();
        printThreadData(thread);
    }

    private void printBeforeAndAfterStarting() {
        ExtendedThread extendedThread = new ExtendedThread();
        extendedThread.setName("ExtendedThread");
        logger.info("Before starting: " + extendedThread.getName());
        printThreadData(extendedThread);

        logger.info("After starting: " + extendedThread.getName());
        extendedThread.start();
        printThreadData(extendedThread);

        RunnableThread runnableThread = new RunnableThread();
        Thread thread = new Thread(runnableThread);
        
        thread.setName("RunnableThread");
        logger.info("Before starting: " + thread.getName());
        printThreadData(thread);
        
        logger.info("After starting: " + thread.getName());
        thread.start();
        printThreadData(thread);
    }

    private void printWithSleep() {
        for (int i = 1; i <= 5; i++) {
            ExtendedThread extendedThread = new ExtendedThread();
            extendedThread.setName("ExtendedThread-" + i);
            logger.info("Spawning: " + extendedThread.getName());
            extendedThread.start();
        }

        for (int i = 1; i <= 5; i++) {
            RunnableThread runnable = new RunnableThread();
            Thread runnableThread = new Thread(runnable);
            runnableThread.setName("RunnableThread-" + i);
            logger.info("Spawning: " + runnableThread.getName());
            runnableThread.start();
        }
    }

    private void printWithCustomSleep() {
        logger.info("Enter number of Threads and Runnable needed:");
        int numOfThreads = Integer.parseInt(sc.nextLine());
        
        for (int i = 1; i <= numOfThreads; i++) {
            logger.info("Enter the sleep time for ExtendedThread " + i + ":");
            ExtendedThread extendedThread = new ExtendedThread(Integer.parseInt(sc.nextLine()));
            extendedThread.setName("ExtendedThread-" + i);
            logger.info("Spawning: " + extendedThread.getName());
            extendedThread.start();
        }

        for (int i = 1; i <= numOfThreads; i++) {
            RunnableThread runnable = new RunnableThread();
            Thread runnableThread = new Thread(runnable);
            runnableThread.setName("RunnableThread-" + i);
            logger.info("Spawning: " + runnableThread.getName());
            runnableThread.start();
        }
    }

    private void printThreadDump() {
        ThreadMXBean threadMXBean = ManagementFactory.getThreadMXBean();
        ThreadInfo[] threadInfos = threadMXBean.dumpAllThreads(true, true);

        for (ThreadInfo threadInfo : threadInfos) {
            System.out.println(threadInfo);
        }
    }

    private void threadDumpTask() {
    	logger.info("Enter how many milliseconds: ");
		long ms = sc.nextLong();
		logger.info("Enter how many threads : ");
		int threadCount = sc.nextInt();
		logger.info("Enter how many minutes in milliseconds to wait : ");
		long minutes = sc.nextLong();
		logger.info("Enter the dump interval: ");
		long dumpInterval = sc.nextLong();
		logger.info("Enter the stop interval: ");
		long stopInterval = sc.nextLong();
		logger.info("Number of dumps : ");
		long dumpCount = sc.nextLong();
    }
}
