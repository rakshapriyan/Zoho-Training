package test;
import bird.Bird;
import child.Parrot;
import java.sql.*;
import java.util.ArrayList;
public class TestRunner{
	public static void main(String[] args){
		Parrot parrot = new Parrot();
		parrot.fly();
		parrot.speak();
		new TestRunner().Run();

	}
	
	public void Run(){
		System.out.println("Running...");
	}
}
