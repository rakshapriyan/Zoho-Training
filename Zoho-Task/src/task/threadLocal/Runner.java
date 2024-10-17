//$Id$
package task.threadLocal;

public class Runner {
	
	public static void main(String[] args) {
		Thread thread1 = new Thread(() ->{
			System.out.println("Thread 1");
			A a = new A();
			a.methodA("raksha");
		});
		thread1.start();
		
		Thread thread2 = new Thread(() ->{
			System.out.println("Thread 1");
			A a = new A();
			a.methodA("priyan");
		});
		thread2.start();
	}

}
