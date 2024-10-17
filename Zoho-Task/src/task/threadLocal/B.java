//$Id$
package task.threadLocal;

public class B {
	C c = new C();
	public void methodB() {
		System.out.println("Method B: "+ CustomThreadLocal.getName());
		c.methodC();
		
	}

}
