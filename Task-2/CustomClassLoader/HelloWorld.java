public class HelloWorld {
    public void sayHello() {
        System.out.println("Hello from HelloWorld!");
    }

    public void printClassLoader() {
        System.out.println("Class loader: " + this.getClass().getClassLoader());
    }
}

