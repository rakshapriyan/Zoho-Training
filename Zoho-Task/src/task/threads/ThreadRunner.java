package task.threads;

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
		default:
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
		logger.log(Level.INFO, "Before starting");
		printThreadData(extendedThread);
		
		logger.log(Level.INFO, "After starting");
		extendedThread.start();
		printThreadData(extendedThread);
		
		
		
		RunnableThread runnableThread = new RunnableThread();
		Thread thread = new Thread(runnableThread);
		
		thread.setName("RunnableThread");
		logger.log(Level.INFO, "Before starting");
		printThreadData(thread);
		
		
		logger.log(Level.INFO, "After starting");
		thread.start();
		printThreadData(thread);
	}
	
	private void printWithSleep() {
		for (int i = 1; i <= 5; i++) {
            ExtendedThread extendedThread = new ExtendedThread();
            extendedThread.setName("ExtendedThread-" + i);
            logger.log(Level.INFO, "Spawning {0}", extendedThread.getName());
            extendedThread.start();
        }

        // Spawn 5 RunnableThread instances with custom names
        for (int i = 1; i <= 5; i++) {
            RunnableThread runnable = new RunnableThread();
            Thread runnableThread = new Thread(runnable);
            runnableThread.setName("RunnableThread-" + i);
            logger.log(Level.INFO, "Spawning {0}", runnableThread.getName());
            runnableThread.start();
        }
	}
	
	
	
	private void printWithCustomSleep() {
		logger.log(Level.INFO, "Enter number of Threads and Runnable needed");
		int numOfThreads = Integer.parseInt(sc.nextLine());
		for (int i = 1; i <= numOfThreads; i++) {
			logger.log(Level.INFO, "Enter the sleep time: ");
            ExtendedThread extendedThread = new ExtendedThread(Integer.parseInt(sc.nextLine()));
            extendedThread.setName("ExtendedThread-" + i);
            logger.log(Level.INFO, "Spawning {0}", extendedThread.getName());
            extendedThread.start();
        }

        for (int i = 1; i <= numOfThreads; i++) {
            RunnableThread runnable = new RunnableThread();
            Thread runnableThread = new Thread(runnable);
            runnableThread.setName("RunnableThread-" + i);
            logger.log(Level.INFO, "Spawning {0}", runnableThread.getName());
            runnableThread.start();
        }
	}
	
}
