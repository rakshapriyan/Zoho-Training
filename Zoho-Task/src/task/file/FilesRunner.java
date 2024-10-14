package task.file;

import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

import task.exception.InvalidInputException;

public class FilesRunner {
    private static final Logger logger = Logger.getLogger(FilesRunner.class.getName());
    private static Scanner sc = new Scanner(System.in);
    private static FilesTask task;
    private static TimeOperations timeOps = new TimeOperations();

    public static void main(String[] args){
      FilesRunner runner = new FilesRunner();
      boolean exit = false;

      while (!exit) {
          try {
              // Display menu
              System.out.println("===== Menu =====");
              System.out.println("1. Create and write to sample.txt");
              System.out.println("2. Store values in Properties and write to myprops.txt");
              System.out.println("3. Read myprops.txt and print properties");
              System.out.println("4. Create files under directory");
              System.out.println("5. Use constructor and print object");
              System.out.println("6. Use POJO class constructor and print");
              System.out.println("7. Use POJO default constructor, set values, and print");
              System.out.println("8. Invoke POJO class using reflection");
              System.out.println("9. Print Enum colors with ordinal");
              System.out.println("10. Singleton class demonstration");
              System.out.print("Select an option (1-10): ");
              
              int choice = Integer.parseInt(sc.nextLine());

              switch (choice) {
                  case 1:
                      runner.writeInFile();
                      break;
                  case 2:
                      runner.writeInProps();
                      break;
                  case 3:
                      runner.readPropsFromFile();
                      break;
                  case 4:
//                      runner.createFilesUnderDir();
                      break;
                  case 5:
                      runner.printObject();
                      break;
                  case 6:
                      runner.printPOJO();
                      break;
                  case 7:
                      runner.printPOJOWithGetter();
                      break;
                  case 8:
                      runner.invokeIndirectly();
                      break;
                  case 9:
                      runner.printColor();
                      break;
                  case 10:
                      runner.checkSingleton();
                      exit = true;  // Assuming Singleton check concludes the task
                      break;
                  default:
                      System.out.println("Invalid choice. Please try again.");
              }
              
          }catch (InvalidInputException e) {
        	  logger.log(Level.SEVERE,e.getMessage(), e);
      		}catch (NumberFormatException e) {
              logger.log(Level.SEVERE, "Invalid input. Please enter a valid number.", e);
          } catch (IOException | ClassNotFoundException | NoSuchMethodException | InstantiationException | IllegalAccessException | InvocationTargetException e) {
              logger.log(Level.SEVERE, "An error occurred while executing the task.", e);
          }
          finally {
        	  sc.close();
          }
      }
  }
    
    
    
  //q3
    private void readPropsFromFile() throws IOException, InvalidInputException {
    	String pathString= getStringInput("Enter the path of the file");
    	
    	Properties properties = task.getProperties();
    	
    	task.loadPropertiesFromFile(properties, pathString);
    	
    	properties.forEach((key, value) -> logger.info("Key: "+key+" value: "+value));
		
	}

    //Q4
    private void readPropsFromFileWithDir() throws IOException, InvalidInputException {
        String dirPath = getStringInput("Enter the directory path of the file");
        String fileName = getStringInput("Enter the file name");
        
        Properties properties = task.getProperties();
        task.loadPropertiesFromFile(properties, dirPath, fileName);
        
        properties.forEach((key, value) -> logger.info("Key: " + key + " value: " + value));
    }


    private void writeInFileWithDir() throws InvalidInputException {
        try {
            String filePath = getStringInput("Enter the directory path");
            String fileName = getStringInput("Enter the file name");
            int numOfLines = getIntegerInput("No of lines");
            
            List<String> lines = new ArrayList<>();
            for (int i = 0; i < numOfLines; i++) {
                lines.add(getStringInput("Enter line " + i + ": "));
            }
            
            task.writeInFile(filePath, fileName, lines);
        } catch (IOException e) {
            logger.log(Level.SEVERE, "File cannot be created properly", e);
            throw new InvalidInputException("file cannot be created properly", e);
        }
    }
    
    



    //Q1
	public void writeInFile() throws InvalidInputException {
        try {
            String path = getStringInput("Enter the path with file name");
            int numOfLines = getIntegerInput("No of lines");
            List<String> lines = new ArrayList<>();
            for (int i = 0; i < numOfLines; i++) {
                lines.add(getStringInput("Enter line " + i + ": "));
                task.writeInFile(path, lines);
            }
        } catch (IOException e) {
            logger.log(Level.SEVERE, "File cannot be created properly", e);
            throw new InvalidInputException("file cannot be created properly", e);
        }
    }

    public void getCurrentTime() {
        timeOps.getCurrentTime();
        logger.info("Current time fetched.");
    }

    public void getCurrentTimeInMillis() {
        timeOps.getCurrentTimeMillis();
        logger.info("Current time in milliseconds fetched.");
    }

    public void compareTime() {
        String zone1 = getStringInput("Enter the first zone: ");
        String zone2 = getStringInput("Enter the second zone: ");
        logger.info("Time comparison between " + zone1 + " and " + zone2);
        logger.info(timeOps.getTimeInZone(zone1) + " and " + timeOps.getTimeInZone(zone2));
    }
    //q2
    public void writeInProps() throws IOException, InvalidInputException {
        Properties properties = task.getProperties(); 
        int numOfProps = getIntegerInput("How many properties to add");
        for (int i = 0; i < numOfProps; i++) {
            task.addProperty(properties, getStringInput("Enter the key"), getStringInput("Enter the Value"));
        }

        
        String path = getStringInput("Enter the file name");
        task.writePropertiesIntofile(properties, path);
        logger.info("Properties written to file: " + path);
    }



    private void writeInPropsWithDir() throws IOException, InvalidInputException {
        Properties properties = task.getProperties(); 
        int numOfProps = getIntegerInput("How many properties to add");
        
        for (int i = 0; i < numOfProps; i++) {
            task.addProperty(properties, getStringInput("Enter the key"), getStringInput("Enter the value"));
        }
        
        String filePath = getStringInput("Enter the directory path");
        String fileName = getStringInput("Enter the file name");
        
        task.writePropertiesIntoFile(properties, filePath, fileName);
        logger.info("Properties written to file: " + filePath + "/" + fileName);
    }
    

    private void printObject() { 
        logger.info(new CustomClass("Raksha").toString());
    }

    private void printPOJO() {
        logger.info(new SamplePOJO(20, "Raksha").toString());
    }

    private void printPOJOWithGetter() {
        SamplePOJO samplePOJO = new SamplePOJO();
        samplePOJO.setAge(20);
        samplePOJO.setName("Raksha");
        logger.info("Name: " + samplePOJO.getName() + ", Age: " + samplePOJO.getAge());
    }

    private void invokeIndirectly() throws ClassNotFoundException, NoSuchMethodException, SecurityException, 
    InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {

    Class<?> pojoClass = Class.forName("task.arrayList.CustomClass");

    Constructor<?> defaultConstructor = pojoClass.getConstructor();
    Object pojoInstance1 = defaultConstructor.newInstance();
    logger.info("POJO instance created with default constructor.");

    Constructor<?> overloadedConstructor = pojoClass.getConstructor(String.class, Integer.class);
    Object pojoInstance2 = overloadedConstructor.newInstance("Raksha", 20);
    logger.info("POJO instance created with overloaded constructor.");

    Method getNameMethod = pojoClass.getMethod("getName");
    String name = (String) getNameMethod.invoke(pojoInstance2);
    logger.info("Getter invoked, name: " + name);

    Method setNameMethod = pojoClass.getMethod("setName", String.class);
    setNameMethod.invoke(pojoInstance2, "Rakshapriyan");
    logger.info("Setter invoked, name updated.");

    name = (String) getNameMethod.invoke(pojoInstance2);
    logger.info("Updated name: " + name);
}


    private void checkSingleton() {
        SingletonClass instance1 = SingletonClass.INSTANCE;
        SingletonClass instance2 = SingletonClass.INSTANCE;
        logger.info("Singleton instances hashCodes: " + instance1.hashCode() + " and " + instance2.hashCode());
    }

    private void printColor() {
        for (Color color : Color.values()) {
            logger.info("Color: " + color.name() + ", Ordinal: " + color.ordinal());
        }
    }

    private String getStringInput(String message) {
        logger.info(message);
        return sc.nextLine();
    }

    private int getIntegerInput(String message) {
        logger.info(message);
        return Integer.parseInt(sc.nextLine());
    }
}





//
//
//
//package task.file;
//
//import java.io.IOException;
//import java.lang.reflect.InvocationTargetException;
//import java.util.logging.Level;
//import java.util.logging.Logger;
//import java.util.Scanner;
//
//import task.exception.InvalidInputException;
//
//public class FilesRunner {
//    private static final Logger logger = Logger.getLogger(FilesRunner.class.getName());
//    private static Scanner sc = new Scanner(System.in);
//    private static FilesTask task = new FilesTask();  // Assuming FilesTask is handling file operations
//    private static TimeOperations timeOps = new TimeOperations();
//
//    public static void main(String[] args) {
//        FilesRunner runner = new FilesRunner();
//        boolean exit = false;
//
//        while (!exit) {
//            try {
//                // Display menu
//                System.out.println("===== Menu =====");
//                System.out.println("1. Create and write to sample.txt");
//                System.out.println("2. Store values in Properties and write to myprops.txt");
//                System.out.println("3. Read myprops.txt and print properties");
//                System.out.println("4. Create files under /home/INC*/myDir");
//                System.out.println("5. Use constructor and print object");
//                System.out.println("6. Use POJO class constructor and print");
//                System.out.println("7. Use POJO default constructor, set values, and print");
//                System.out.println("8. Invoke POJO class using reflection");
//                System.out.println("9. Print Enum colors with ordinal");
//                System.out.println("10. Singleton class demonstration");
//                System.out.print("Select an option (1-10): ");
//                
//                int choice = Integer.parseInt(sc.nextLine());
//
//                switch (choice) {
//                    case 1:
//                        runner.writeInFile();
//                        break;
//                    case 2:
//                        runner.writeInProps();
//                        break;
//                    case 3:
//                        runner.readProps();
//                        break;
//                    case 4:
//                        runner.createFilesUnderDir();
//                        break;
//                    case 5:
//                        runner.printObject();
//                        break;
//                    case 6:
//                        runner.printPOJO();
//                        break;
//                    case 7:
//                        runner.printPOJOWithGetter();
//                        break;
//                    case 8:
//                        runner.invokeIndirectly();
//                        break;
//                    case 9:
//                        runner.printColor();
//                        break;
//                    case 10:
//                        runner.checkSingleton();
//                        exit = true;  // Assuming Singleton check concludes the task
//                        break;
//                    default:
//                        System.out.println("Invalid choice. Please try again.");
//                }
//            } catch (NumberFormatException e) {
//                logger.log(Level.SEVERE, "Invalid input. Please enter a valid number.", e);
//            } catch (IOException | ClassNotFoundException | NoSuchMethodException | InstantiationException | IllegalAccessException | InvocationTargetException e) {
//                logger.log(Level.SEVERE, "An error occurred while executing the task.", e);
//            }
//        }
//    }
//
//    public void writeInFile() throws IOException, InvalidInputException {
//        String path = "/home/INC*/myDir/sample.txt";
//        logger.info("Writing to " + path);
//        task.createFile(path);  // Assuming FilesTask has a method to create files
//        task.writeInFile(path, List.of(
//                "Programmatically created file.",
//                "These words were written programmatically.",
//                "All is Well. Be happy & enjoy the moment."
//        ));
//        logger.info("File written successfully.");
//    }
//
//    public void writeInProps() throws IOException {
//        Properties properties = task.getProperties();
//        task.addProperty(properties, "key1", "value1");
//        task.addProperty(properties, "key2", "value2");
//        task.addProperty(properties, "key3", "value3");
//        task.addProperty(properties, "key4", "value4");
//        task.addProperty(properties, "key5", "value5");
//
//        String path = "/home/INC*/myDir/myprops.txt";
//        logger.info("Writing properties to " + path);
//        task.writePropertiesToFile(properties, path);
//        logger.info("Properties written successfully.");
//    }
//
//    public void readProps() throws IOException {
//        String path = "/home/INC*/myDir/myprops.txt";
//        logger.info("Reading properties from " + path);
//        Properties properties = task.readPropertiesFromFile(path);
//        logger.info("Properties read: " + properties);
//    }
//
//    public void createFilesUnderDir() throws IOException {
//        task.createDir("/home/INC*/myDir");  // Assuming FilesTask has createDir method
//        writeInFile();
//        writeInProps();
//    }
//
//    public void printObject() {
//        CustomClass customClass = new CustomClass("Raksha");
//        logger.info(customClass.toString());
//    }
//
//    public void printPOJO() {
//        SamplePOJO pojo = new SamplePOJO(20, "Raksha");
//        logger.info(pojo.toString());
//    }
//
//    public void printPOJOWithGetter() {
//        SamplePOJO samplePOJO = new SamplePOJO();
//        samplePOJO.setAge(20);
//        samplePOJO.setName("Raksha");
//        logger.info("Name: " + samplePOJO.getName() + ", Age: " + samplePOJO.getAge());
//    }
//
//    public void invokeIndirectly() throws ClassNotFoundException, NoSuchMethodException, InstantiationException, IllegalAccessException, InvocationTargetException {
//        Class<?> pojoClass = Class.forName("task.arrayList.CustomClass");
//
//        Constructor<?> defaultConstructor = pojoClass.getConstructor();
//        Object pojoInstance1 = defaultConstructor.newInstance();
//        logger.info("POJO instance created with default constructor.");
//
//        Constructor<?> overloadedConstructor = pojoClass.getConstructor(String.class, Integer.class);
//        Object pojoInstance2 = overloadedConstructor.newInstance("Raksha", 20);
//        logger.info("POJO instance created with overloaded constructor.");
//
//        Method getNameMethod = pojoClass.getMethod("getName");
//        String name = (String) getNameMethod.invoke(pojoInstance2);
//        logger.info("Getter invoked, name: " + name);
//
//        Method setNameMethod = pojoClass.getMethod("setName", String.class);
//        setNameMethod.invoke(pojoInstance2, "Rakshapriyan");
//        logger.info("Setter invoked, name updated.");
//    }
//
//    public void checkSingleton() {
//        SingletonClass instance1 = SingletonClass.INSTANCE;
//        SingletonClass instance2 = SingletonClass.INSTANCE;
//        logger.info("Singleton instances hashCodes: " + instance1.hashCode() + " and " + instance2.hashCode());
//    }
//
//    public void printColor() {
//        for (Color color : Color.values()) {
//            logger.info("Color: " + color.name() + ", Ordinal: " + color.ordinal());
//        }
//    }
//}
//
