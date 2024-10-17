//$Id$
package task.threadLocal;

public class A {
	B b = new B();
	public void methodA(String name) {
		CustomThreadLocal.setName(name);
		b.methodB();
	}

}
