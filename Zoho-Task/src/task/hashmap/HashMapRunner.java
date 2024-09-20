package task.hashmap;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

import task.arrayList.CustomClass;
import task.exception.InvalidInputException;

public class HashMapRunner {
	
	private static HashMapTask task = new HashMapTask();
	private static  Scanner sc = new Scanner(System.in);
	
	
	public static void main(String[] args) {
		HashMapRunner runner = new HashMapRunner();
    	boolean exit = false;

        while (!exit) {
        	runner.displayOptions();
            int choice = Integer.parseInt(sc.nextLine());

            try {
            	
            	if(choice == -1) {
            		exit = true;
            		break;
            	}
                switch (choice) {
                    case 1: // Q1
                    	runner.createEmptyHashMap();
                    	break;
                    case 2: // Q2
                    	runner.printStringHashMap();
                    	break;
                    case 3: // Q3
                    	runner.printIntHashMap();
                    	break;
                    case 4: // Q4
                    	runner.printStringIntHashMap();
                    	break;
                    case 5: // Q5
                    	runner.printObjectHashMap();
                    	break;
                    case 6: // Q6
                    	runner.printValueIfNull();
                    	break;
                    case 7: // Q7
                    	runner.printValueIfNull();
                    	break;
                    case 8: // Q8
                    	runner.printIsKeyPresent();
                    	break;
                    case 9: // Q9
                    	runner.printIsValuePresent();
                    	break;
                    case 10: // Q10
                    	runner.printChangeValues();
                    	break;
                    case 11: // Q11
                    	runner.printGetValue();
                    	break;
                    case 12: // Q12
                    	runner.printGetValue();
                    	break;
                    case 13: // Q13 -
                    	runner.printZohoForNonExist();
                    	break;
                    case 14: // Q14 
                    	runner.printRemoveKey();
                    	break;
                    case 15: // Q15
                    	runner.printRemoveKeyWithValue();
                    	break;
                    case 16: // Q16
                    	runner.printReplaceValue();
                    	break;
                    case 17: // Q17
                    	runner.printReplaceValueWithCheck();
                    	break;
                    case 18: // Q18
                    	runner.printTransferHashMap();
                    	break;
                    case 19: // Q19
                        runner.iterateAndPrint();
                        break;
                    case 20:  //Q20
                    	runner.removeAll();
                    	break;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            }
            catch(InvalidInputException e) {
            	System.out.println("Caused by:     "+e.getCause().getClass().getName());
            	System.out.println(e.getMessage());
            	e.printStackTrace();
            }
            catch (Exception e) {
            	System.out.println("Caused by:     "+e.getCause().getClass().getName());
            	System.out.println(e.getMessage());
            	e.printStackTrace();
            } 
            finally {
				sc.close();
			}
            
        }


    }
	
	public void displayOptions() {
		System.out.println("1. Create Empty hashMap");
		System.out.println("2. Create String hashmap");
		System.out.println("3: Create Integer hashmap");
		System.out.println("4: Create String and Integer hashmap");
		System.out.println("5. With own Object");
		System.out.println("6. Add with null key");
		System.out.println("7. Add with non null value and key");
		System.out.println("8. To check a key exists");
		System.out.println("9. To check a value exists");
		System.out.println("10. Change values for all the keys");
		System.out.println("11. Get the value of  existing key");
		System.out.println("12. Get the value of non existing key");
		System.out.println("13. return zoho for non existing key");
		System.out.println("14. Remove an existing key");
		System.out.println("15. Remove existing key and value");
		System.out.println("16. Replace value of existing key");
		System.out.println("17. Replace value only if value matches");
		System.out.println("18. Transfer to another hashmap");
		System.out.println("19. Iterate and print all values and keys");
		System.out.println("20. remove all entries");
		System.out.println("Enter -1 to exit");
	}
	
	//Q1
	public void createEmptyHashMap()throws InvalidInputException {
	    
	        HashMap hm = (HashMap) task.returnHashMap();
	        printLength(hm);
	    
	}
	
	

	//Q2
	public void printStringHashMap() throws InvalidInputException{
	    try {
	        int size = getIntegerInput("Enter the size of the hashmap: ");
	        HashMap<String, String> hm = (HashMap) task.returnHashMap();
	        getStringHashMap(hm, size);
	        printHashMap(hm);
	        printLength(hm);
	    } catch (InvalidInputException e) {
	        handleException(e);
	    }
	}

	//Q3
	public void printIntHashMap()throws InvalidInputException {
	    try {
	        int size = getIntegerInput("Enter the size of the hashmap: ");
	        HashMap<Integer, Integer> hm = (HashMap) task.returnHashMap();
	        getIntegerHashMap(hm, size);
	        printHashMap(hm);
	        printLength(hm);
	    } catch (InvalidInputException e) {
	        handleException(e);
	    }
	}

	//Q4
	public void printStringIntHashMap()throws InvalidInputException {
	    try {
	        int size = getIntegerInput("Enter the size of the hashmap: ");
	        HashMap<String, Integer> hm = (HashMap) task.returnHashMap();
	        getStringIntHashMap(hm, size);
	        printHashMap(hm);
	        printLength(hm);
	    } catch (InvalidInputException e) {
	        handleException(e);
	    }
	}

	//Q5
	public void printObjectHashMap() throws InvalidInputException{
	    try {
	        int size = getIntegerInput("Enter the size of the hashmap: ");
	        HashMap<String, CustomClass> hm = (HashMap) task.returnHashMap();
	        getObjectHashMap(hm, size);
	        printLength(hm);
	    } catch (InvalidInputException e) {
	        handleException(e);
	    }
	}
	
	
	//Q6
	public void printValueIfNull() throws InvalidInputException{
		try {
			HashMap<String, CustomClass> hm = (HashMap) task.returnHashMap();
			task.add(hm, null, null);
			printHashMap(hm);
		}
		 catch (InvalidInputException e) {
	        handleException(e);
	    }
	}
	
	

	//Q8
	public void printIsKeyPresent()throws InvalidInputException {
	    try {
	        int size = getIntegerInput("Enter the size of the hashmap: ");
	        HashMap<String, String> hm = (HashMap) task.returnHashMap();
	        getStringHashMap(hm, size);
	        String key = getStringInput("Enter the key you want to check: ");
	        System.out.println(task.isKeyPresent(hm, key));
	    } catch (InvalidInputException e) {
	        handleException(e);
	    }
	}

	//Q9
	public void printIsValuePresent() throws InvalidInputException{
	    try {
	        int size = getIntegerInput("Enter the size of the hashmap: ");
	        HashMap<String, String> hm = (HashMap) task.returnHashMap();
	        getStringHashMap(hm, size);
	        String value = getStringInput("Enter the key you want to check: ");
	        System.out.println(task.isValuePresent(hm, value));
	    } catch (InvalidInputException e) {
	        handleException(e);
	    }
	}

	//Q10
	public void printChangeValues() throws InvalidInputException{
	    try {
	        int size = getIntegerInput("Enter the size of the hashmap: ");
	        HashMap<String, String> hm = (HashMap) task.returnHashMap();
	        getStringHashMap(hm, size);
	        printHashMap(hm);
	        printLength(hm);
	        System.out.println("Enter the values of the keys you want to change: ");
	    } catch (InvalidInputException e) {
	        handleException(e);
	    }
	}

	//Q11
	public void printGetValue() throws InvalidInputException{
	    try {
	        int size = getIntegerInput("Enter the size of the hashmap: ");
	        HashMap<String, String> hm = (HashMap) task.returnHashMap();
	        getStringHashMap(hm, size);
	        String key = getStringInput("Enter the key to check: ");
	        System.out.println("the value for " + key + " is: " + task.getValue(hm, key));
	    } catch (InvalidInputException e) {
	        handleException(e);
	    }
	}
	
	
	
	//Q12
	
	
	

	//Q13
	public void printZohoForNonExist() throws InvalidInputException{
	    try {
	        int size = getIntegerInput("Enter the size of the hashmap: ");
	        HashMap<String, String> hm = (HashMap) task.returnHashMap();
	        getStringHashMap(hm, size);
	        printHashMap(hm);
	        printLength(hm);
	        String key = getStringInput("Enter the key to check: ");
	        System.out.println("the value for " + key + " is: " + task.getOrDefault(hm, key, "Zoho"));
	        printHashMap(hm);
	        printLength(hm);
	    } catch (InvalidInputException e) {
	        handleException(e);
	    }
	}

	//Q14
	public void printRemoveKey() throws InvalidInputException{
	    try {
	        int size = getIntegerInput("Enter the size of the hashmap: ");
	        HashMap<String, String> hm = (HashMap) task.returnHashMap();
	        getStringHashMap(hm, size);
	        printHashMap(hm);
	        printLength(hm);
	        String key = getStringInput("Enter the key to remove: ");
	        task.removeKey(hm, key);
	        printHashMap(hm);
	        printLength(hm);
	    } catch (InvalidInputException e) {
	        handleException(e);
	    }
	}

	//Q15
	public void printRemoveKeyWithValue()throws InvalidInputException {
	    try {
	        int size = getIntegerInput("Enter the size of the hashmap: ");
	        HashMap<String, String> hm = (HashMap) task.returnHashMap();
	        getStringHashMap(hm, size);
	        printHashMap(hm);
	        printLength(hm);
	        String key = getStringInput("Enter the key to remove: ");
	        String value = getStringInput("Enter the Value to remove: ");
	        task.removeKeyWithValue(hm, key, value);
	        printHashMap(hm);
	        printLength(hm);
	    } catch (InvalidInputException e) {
	        handleException(e);
	    }
	}

	//Q16
	public void printReplaceValue() throws InvalidInputException{
	    try {
	        int size = getIntegerInput("Enter the size of the hashmap: ");
	        HashMap<String, String> hm = (HashMap) task.returnHashMap();
	        getStringHashMap(hm, size);
	        printHashMap(hm);
	        printLength(hm);
	        String key = getStringInput("Enter the key: ");
	        String value = getStringInput("Enter the Value to replace: ");
	    } catch (InvalidInputException e) {
	        handleException(e);
	    }
	}

	//Q17
	public void printReplaceValueWithCheck() throws InvalidInputException{
	    try {
	        int size = getIntegerInput("Enter the size of the hashmap: ");
	        HashMap<String, String> hm = (HashMap) task.returnHashMap();
	        getStringHashMap(hm, size);
	        printHashMap(hm);
	        printLength(hm);
	        String key = getStringInput("Enter the key: ");
	        String oldValue = getStringInput("Enter the old Value to replace: ");
	        String newValue = getStringInput("Enter the new Value to replace: ");
	        task.replace(hm, key, oldValue, newValue);
	        printHashMap(hm);
	        printLength(hm);
	    } catch (InvalidInputException e) {
	        handleException(e);
	    }
	}

	//Q18
	public void printTransferHashMap()throws InvalidInputException {
	    try {
	        int size = getIntegerInput("Enter the size of the hashmap: ");
	        HashMap<String, String> hm = (HashMap) task.returnHashMap();
	        getStringHashMap(hm, size);
	        printHashMap(hm);
	        printLength(hm);
	        HashMap<String, String> finalMap = (HashMap) task.returnHashMap();
	        task.copyMap(hm, finalMap);
	        printHashMap(hm);
	        printLength(hm);
	    } catch (InvalidInputException e) {
	        handleException(e);
	    }
	}

	//Q19
	public void iterateAndPrint()throws InvalidInputException {
	    try {
	        int size = getIntegerInput("Enter the size of the hashmap: ");
	        HashMap<String, String> hm = (HashMap) task.returnHashMap();
	        getStringHashMap(hm, size);
	        for (Entry<String, String> entry : hm.entrySet()) {
	            System.out.println("Key: " + entry.getKey() + ", Value: " + entry.getValue());
	        }
	    } catch (InvalidInputException e) {
	        handleException(e);
	    }
	}

	//Q20
	public void removeAll() throws InvalidInputException{
	    try {
	        int size = getIntegerInput("Enter the size of the hashmap: ");
	        HashMap<String, String> hm = (HashMap) task.returnHashMap();
	        getStringHashMap(hm, size);
	        printHashMap(hm);
	        printLength(hm);
	        task.removeAll(hm);
	        printLength(hm);
	    } catch (InvalidInputException e) {
	        handleException(e);
	    }
	}

	
	private Map getObjectHashMap(HashMap<String, CustomClass> hm, int size) throws InvalidInputException{
		for(int i = 0; i<size; i++) {
			String key = getStringInput("Enter the "+i+"th key: ");
			System.out.println("For object:");
			int intVal = getIntegerInput("Enter the object's integer value: ");
			String strVal = getStringInput("Enter the object's String value: ");
			task.add(hm, key, new CustomClass(intVal, strVal));
		}
		
		return hm;
		
	}

	public Map getStringHashMap(HashMap<String, String> hm, int size)throws InvalidInputException {
	    try {
	        for(int i = 0; i < size; i++) {
	            String key = getStringInput("Enter the " + i + "th key: ");
	            String value = getStringInput("Enter the " + i + "th value: ");
	            task.add(hm, key, value);
	        }
	    } catch (InvalidInputException e) {
	        handleException(e);
	    }
	    return hm;
	}

	public Map getStringIntHashMap(HashMap<String, Integer> hm, int size) throws InvalidInputException{
	    try {
	        for(int i = 0; i < size; i++) {
	            String key = getStringInput("Enter the " + i + "th key: ");
	            int value = getIntegerInput("Enter the " + i + "th value: ");
	            task.add(hm, key, value);
	        }
	    } catch (InvalidInputException e) {
	        handleException(e);
	    }
	    return hm;
	}

	public Map getIntegerHashMap(HashMap<Integer, Integer> hm, int size) throws InvalidInputException{
	    try {
	        for(int i = 0; i < size; i++) {
	            int key = getIntegerInput("Enter the " + i + "th key: ");
	            int value = getIntegerInput("Enter the " + i + "th value: ");
	            task.add(hm, key, value);
	        }
	    } catch (InvalidInputException e) {
	        handleException(e);
	    }
	    return hm;
	}

	
	
	
	public int getIntegerInput(String message) {
		System.out.println(message);
		return Integer.parseInt(sc.nextLine());
	}
	
	
	public String getStringInput(String message) {
		System.out.println(message);
		return sc.nextLine();
	}
	
	public void printLength(Map map)throws InvalidInputException {
		try {
			System.out.println("The length of the hashMap is: "+ task.size(map));
		}
		catch(InvalidInputException e) {
			handleException(e);
		}
	}
	
	public void printHashMap(Map map) {
		System.out.println("The hashMap is: "+ map);
	}
	
	
	private static void handleException(Exception e) throws InvalidInputException {
    	throw new InvalidInputException(e.getMessage(), e);
    }

}
