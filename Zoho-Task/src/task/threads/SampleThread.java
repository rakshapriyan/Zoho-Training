//$Id$
package task.threads;

public class SampleThread extends Thread{
	private static ThreadLocal<Integer> threadLocal = ThreadLocal.withInitial(() -> 1);
	
    public void run() {
        System.out.println(Thread.currentThread().getName() + " initial value: " + threadLocal.get());
        
        threadLocal.set((int)(Math.random() * 100));

        System.out.println(Thread.currentThread().getName() + " updated value: " + threadLocal.get());
    }
}
