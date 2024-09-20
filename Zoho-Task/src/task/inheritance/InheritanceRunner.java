package task.inheritance;
import task.inheritance.XUV;
import task.inheritance.Swift;
import task.inheritance.SCross;
import task.inheritance.Car;
import task.inheritance.BirdAbstract;
import task.inheritance.ParrotMod;
import java.util.Scanner;

public class InheritanceRunner {

    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
    	InheritanceRunner runner = new InheritanceRunner();
        //runner.createAndPrintSwift();
        //runner.createAndPrintSCross();
        //runner.getCar(new Swift());
        //Car swift = new Swift();
        //swift.setEngineNumber("6");
        
        //runner.acceptSwift(swift);
        
        
        SCross scross = new SCross();
        scross.maintainance();
        
        Car carScross = new SCross();
        carScross.maintainance();
        
        Swift swift = new Swift();
        swift.maintainance();
        
        
        XUV xuv = new XUV();
        
        //BirdAbstract birdAbstract = new BirdAbstract();
        ParrotMod parrot = new ParrotMod();
        parrot.fly();
        parrot.speak();
        
        
        Duck duck = new Duck();

        duck.fly(); 
        duck.speak();
        
        sc.close();
        
    }
    
    
    
    private  Swift createSwift() {
        Swift swift = new Swift();
        System.out.println("Enter details for Swift:");

        swift.setYearOfMake(getIntInput("Year of Make: "));
        swift.setEngineNumber(getStringInput("Engine Number: "));
        swift.setType(getStringInput("Type (Hatchback, Sedan, SUV): "));
        swift.setSeats(getIntInput("Number of Seats: "));
        swift.setAirbags(getIntInput("Number of Airbags: "));
        swift.setModel(getStringInput("Model: "));
        swift.setColor(getStringInput("Color: "));

        return swift;
    }
    
    
    private void createAndPrintSwift() {
        Swift swift = new Swift();
        System.out.println("Enter details for Swift:");

        swift.setSeats(getIntInput("Number of Seats: "));
        swift.setAirbags(getIntInput("Number of Airbags: "));
        swift.setModel(getStringInput("Model: "));
        swift.setColor(getStringInput("Color: "));
        
        System.out.println("Seats: " + swift.getSeats());
    	System.out.println("Airbags: " + swift.getAirbags());
    	System.out.println("Model: " + swift.getModel());
    	System.out.println("Color: " + swift.getColor());
        

    }
    
    private void getCar(Car car) {
    
	    if (car instanceof Swift) {
		System.out.println("Car Type: Hatchback");
	    } else if (car instanceof SCross) {
		System.out.println("Car Type: Sedan");
	    } else if (car instanceof XUV) {
		System.out.println("Car Type: SUV");
	    } else {
		System.out.println("Unknown car type.");
	    }
}



    private void createAndPrintSCross() {
        SCross sCross = new SCross();
        System.out.println("\nEnter details for SCross:");

        sCross.setYearOfMake(getIntInput("Year of Make: "));
        sCross.setEngineNumber(getStringInput("Engine Number: "));
        sCross.setType(getStringInput("Type (Hatchback, Sedan, SUV): "));
        sCross.setSeats(getIntInput("Number of Seats: "));
        sCross.setAirbags(getIntInput("Number of Airbags: "));
        sCross.setModel(getStringInput("Model: "));
        sCross.setColor(getStringInput("Color: "));

        System.out.println("\nSCross Details:");
    	System.out.println("Year of Make: " + sCross.getYearOfMake());
    	System.out.println("Engine Number: " + sCross.getEngineNumber());
    	System.out.println("Type: " + sCross.getType());
    	System.out.println("Seats: " + sCross.getSeats());
    	System.out.println("Airbags: " + sCross.getAirbags());
    	System.out.println("Model: " + sCross.getModel());
    	System.out.println("Color: " + sCross.getColor());
    }
    
    
    public void acceptSwift(Swift swift){
    	System.out.println("accepted swift");
    }


    private  int getIntInput(String message) {
        System.out.println(message);
        return Integer.parseInt(sc.nextLine());
    }

    private String getStringInput(String message) {
        System.out.println(message);
        return sc.nextLine();
    }
}

