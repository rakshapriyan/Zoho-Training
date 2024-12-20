package task.threads;

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadInfo;
import java.lang.management.ThreadMXBean;
import java.util.Map;
import java.util.Scanner;
import java.util.logging.Logger;

public class ThreadRunner {
    private static Scanner sc = new Scanner(System.in);
    private static final Logger logger = Logger.getLogger(ThreadRunner.class.getName());

    public static void main(String[] args) {
        ThreadRunner threadRunner = new ThreadRunner();
        logger.info("Enter your choice (1-7):");
        int choice = Integer.parseInt(sc.nextLine());
        try {
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
                case 6:
                    threadRunner.threadDumpTask();
                    break;
                case 7:
                    threadRunner.printThreadDumpWithMXBean();
                    break;
                case 8:
                    threadRunner.printThreadDumpWithStackTraces();
                    break;
                default:
                    logger.severe("Invalid choice: " + choice);
                    break;
            }
        } catch (Exception e) {
            logger.severe(e.getMessage());
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
        logger.info("Enter number of Threads and Runnables needed:");
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

    private void threadDumpTask() throws InterruptedException {
        logger.info("Enter how many milliseconds for sleep: ");
        long ms = sc.nextLong();
        sc.nextLine();
        logger.info("Enter how many threads: ");
        int threadCount = sc.nextInt();
        sc.nextLine();
        logger.info("Enter how many minutes to wait before stopping: ");
        long minutes = sc.nextLong();
        sc.nextLine();
        logger.info("Enter the number of dumps: ");
        long dumpCount = sc.nextLong();
        sc.nextLine();
        logger.info("Enter the Interval of dumps: ");
        long dumpInterval = sc.nextLong();
        sc.nextLine();

        ExtendedThread[] extendedThreads = new ExtendedThread[threadCount];
        Thread[] runnableThreads = new Thread[threadCount];
        RunnableThread[] runnables = new RunnableThread[threadCount];

        for (int i = 0; i < threadCount; i++) {
            extendedThreads[i] = new ExtendedThread(ms * (i + 1));
            extendedThreads[i].setName("ExtendedThread-" + i);
            extendedThreads[i].start();

            runnables[i] = new RunnableThread(ms * (i + 1));
            runnableThreads[i] = new Thread(runnables[i], "RunnableThread-" + i);
            runnableThreads[i].start();
        }

        Thread.sleep(minutes * 60 * 1000);

        for (int i = 0; i < dumpCount; i++) {
            printThreadDumpWithMXBean();
            Thread.sleep(dumpInterval);
        }
    }

    private void printThreadDumpWithMXBean() {
        ThreadMXBean threadMXBean = ManagementFactory.getThreadMXBean();
        ThreadInfo[] threadInfos = threadMXBean.dumpAllThreads(true, true);

        logger.info("Thread Dump:");
        for (ThreadInfo threadInfo : threadInfos) {
            logger.info(threadInfo.toString());
        }
    }

    private void printThreadDumpWithStackTraces() {
        for (Map.Entry<Thread, StackTraceElement[]> entry : Thread.getAllStackTraces().entrySet()) {
            Thread thread = entry.getKey();
            StackTraceElement[] stackTraceElements = entry.getValue();

            logger.info("Thread: " + thread.getName() + " - State: " + thread.getState());
            for (StackTraceElement element : stackTraceElements) {
                logger.info(element.toString());
            }
            logger.info("");
        }
    }
}
