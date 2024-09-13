package test;

import bird.Bird;
import child.Parrot;

public class TestRunner {
    public static void main(String[] args) {
        Parrot parrot = new Parrot();

        ClassLoader testRunnerClassLoader = TestRunner.class.getClassLoader();
        System.out.println("TestRunner class is loaded by: " + testRunnerClassLoader);

        ClassLoader parrotClassLoader = Parrot.class.getClassLoader();
        System.out.println("Parrot class is loaded by: " + parrotClassLoader);

        parrot.fly();
        parrot.speak();
    }
}

