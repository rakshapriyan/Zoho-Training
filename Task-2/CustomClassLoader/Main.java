public class Main {
    public static void main(String[] args) {
        // Path to the directory where HelloWorld.class is located
        String classPath = "classes";

        // Create an instance of CustomClassLoader
        CustomClassLoader customClassLoader = new CustomClassLoader(classPath);

        try {
            // Load the HelloWorld class
            Class<?> clazz = customClassLoader.loadClass("HelloWorld");
            
            // Create an instance of HelloWorld
            Object obj = clazz.getDeclaredConstructor().newInstance();
            
            // Invoke the sayHello method
            clazz.getMethod("sayHello").invoke(obj);
            
            // Invoke the printClassLoader method
            clazz.getMethod("printClassLoader").invoke(obj);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

