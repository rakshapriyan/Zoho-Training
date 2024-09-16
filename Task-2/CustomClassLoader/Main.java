public class Main {
    public static void main(String[] args) {
        String classPath = "classes";

        CustomClassLoader customClassLoader = new CustomClassLoader(classPath);

        try {
            Class<?> c = customClassLoader.loadClass("HelloWorld");
            
            Object obj = c.getDeclaredConstructor().newInstance();
            
            c.getMethod("sayHello").invoke(obj);
            
            c.getMethod("printClassLoader").invoke(obj);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

