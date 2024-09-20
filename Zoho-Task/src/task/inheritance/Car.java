package task.inheritance;
public class Car {
    private int yearOfMake;
    private String engineNumber;
    private String type;
    
    public Car(){
    }
    
    public Car(String message) {
        System.out.println(message);
    }

    public int getYearOfMake() {
        return yearOfMake;
    }

    public void setYearOfMake(int yearOfMake) {
        this.yearOfMake = yearOfMake;
    }

    public String getEngineNumber() {
        return engineNumber;
    }

    public void setEngineNumber(String engineNumber) {
        this.engineNumber = engineNumber;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
    
    
    public void maintainance(){
    	System.out.println("Car under maintainance");
    }
}

