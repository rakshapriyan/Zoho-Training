//$Id$
package task.threads;

public class ExampleThreadLocal  {
	
	public static void main(String[] args) {
		SampleThread thread1 = new SampleThread();
		SampleThread thread2 = new SampleThread();
		SampleThread thread3 = new SampleThread();
		
		thread1.start();
		thread2.start();
		thread3.start();
		
	}
}
