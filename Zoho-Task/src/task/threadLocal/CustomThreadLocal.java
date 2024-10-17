//$Id$
package task.threadLocal;

public class CustomThreadLocal {
	private static ThreadLocal<String> name = new ThreadLocal<>();
	
	public static void setName(String Name) {
		name.set(Name);
	}
	
	public static String getName() {
		return name.get();
	}
	
	
}
