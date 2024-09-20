package task.arrayList;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

import task.exception.InvalidInputException;

public class ArrayListRunner {

    private static ArrayListTask task = new ArrayListTask();
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
    	ArrayListRunner arrayListRunner = new ArrayListRunner();
        boolean exit = false;

        while (!exit) {
        	arrayListRunner.displayOptions();
            int choice = Integer.parseInt(sc.nextLine());

            try {
                switch (choice) {
                    case 1: // Q1
                    	arrayListRunner.createEmptyList();
                        break;
                    case 2: // Q2
                    	arrayListRunner.createWithStringArray();
                        break;
                    case 3: // Q3
                    	arrayListRunner.createWithInteger();
                        break;
                    case 4: // Q4
                    	arrayListRunner.addCustomObjects();
                        break;
                    case 5: // Q5
                    	arrayListRunner.addObjects();
                        break;
                    case 6: // Q6
                    	arrayListRunner.findIndexOf();
                        break;
                    case 7: // Q7
                    	arrayListRunner.printElement();
                        break;
                    case 8: // Q8
                    	arrayListRunner.findElementAtIndex();
                        break;
                    case 9: // Q9
                    	arrayListRunner.findIndexOfDuplicate();
                        break;
                    case 10: // Q10
                    	arrayListRunner.insertInBetween();
                        break;
                    case 11: // Q11
                    	arrayListRunner.createSubArrayList();
                        break;
                    case 12: // Q12
                    	arrayListRunner.mergeList();
                        break;
                    case 13: // Q13 - 
                    	arrayListRunner.mergeListRev();
                        // Add your method here
                        break;
                    case 14: // Q14 
                    	arrayListRunner.createWithDecimal();
                        break;
                    case 15: // Q15
                    	arrayListRunner.removeCommonElements();
                        break;
                    case 16: // Q16
                    	arrayListRunner.retainCommonElements();
                        break;
                    case 17: // Q17
                    	arrayListRunner.removeAllFloat();
                        break;
                    case 18: // Q18
                    	arrayListRunner.isPresent();
                        break;
                    case 19: // Exit
                        exit = true;
                        System.out.println("Exiting the program.");
                        break;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            } catch (InvalidInputException e) {
            	System.out.println("Caused by:     "+e.getCause().getClass().getName());
            	System.out.println(e.getMessage());
            	e.printStackTrace();
            } catch (Exception e) {
                System.out.println("An unexpected error occurred: " + e.getMessage());
                e.printStackTrace();
            }
        }

        sc.close();
    }

    private void displayOptions() {
        System.out.println("\nMenu:");
        System.out.println("1. Create empty arrayList");
        System.out.println("2. Create String ArrayList");
        System.out.println("3. Create Integer ArrayList");
        System.out.println("4. Add Custom Objects to ArrayList");
        System.out.println("5. Add Any Objects to ArrayList");
        System.out.println("6. Find Index of Element");
        System.out.println("7. Print Elements");
        System.out.println("8. Find Element at Index");
        System.out.println("9. Find Index of Duplicate");
        System.out.println("10. Insert Element in Between");
        System.out.println("11. Create sub array list ");
        System.out.println("12. Merge 2 array list");
        System.out.println("13. Merge 2 array List(2nd one at the beginning)");
        System.out.println("14. Create Decimal ArrayList");
        System.out.println("15. Remove Common Elements");
        System.out.println("16. Retain Common Elements");
        System.out.println("17. Remove All Float Elements");
        System.out.println("18. Check if Element is Present");
        System.out.println("19. Exit");
        System.out.print("Enter your choice: ");
    }

    private ArrayList<String> addStrings() throws InvalidInputException {
        ArrayList<String> stringList = (ArrayList)task.getArrayList();
        System.out.println("Enter the number of elements: ");
        int size = Integer.parseInt(sc.nextLine());

        for (int i = 0; i < size; i++) {
            System.out.print("Enter string " + (i + 1) + ": ");
            task.add(stringList, sc.nextLine());
        }

        return stringList;
    }
    
    
    //Q1
    
    public  void createEmptyList()throws InvalidInputException {
        try {
            ArrayList<String> stringList = (ArrayList)task.getArrayList();
            System.out.println("The size of an empty array list is: "+task.size(stringList));
        } catch (InvalidInputException e) {
            handleException(e);
        }
    }
    
    
//Q2
    public void createWithStringArray()throws InvalidInputException {
        try {
            ArrayList<String> stringList = addStrings();
            System.out.println(stringList);
        } catch (InvalidInputException e) {
            handleException(e);
        }
    }
    
    
    
//Q3
    public void createWithInteger() throws InvalidInputException{
        try {
            ArrayList<Integer> integerList = (ArrayList)task.getArrayList();
            System.out.println("Enter the number of elements: ");
            int size = Integer.parseInt(sc.nextLine());

            for (int i = 0; i < size; i++) {
                System.out.print("Enter number " + (i + 1) + ": ");
                task.add(integerList, Integer.parseInt(sc.nextLine()));
            }

            System.out.println(integerList);
        } catch (InvalidInputException e) {
            handleException(e);
        }
    }
    
    
    //Q4
    public void addCustomObjects() throws InvalidInputException{
    	ArrayList<Object> customObjList = (ArrayList)task.getArrayList();
    	System.out.println("Enter the number of objects to add: ");
        int objSize = Integer.parseInt(sc.nextLine());

        for (int i = 0; i < objSize; i++) {
            System.out.print("Enter the integer value: ");
            int intVar = Integer.parseInt(sc.nextLine());
            System.out.print("Enter the string value: ");
            String stringVar = sc.nextLine();
            task.add(customObjList, new CustomClass(intVar, stringVar));
        }
        
        
        System.out.println("Total size of the object list: " + task.size(customObjList));
        
    }
    
    
//Q5
    public void addObjects() throws InvalidInputException{
        try {
            ArrayList<Object> objList =(ArrayList) task.getArrayList();
            System.out.println("Enter the number of Integer elements wanted to add: ");
            int intSize = Integer.parseInt(sc.nextLine());

            for (int i = 0; i < intSize; i++) {
                System.out.print("Enter Number " + (i + 1) + ": ");
                task.add(objList, Integer.parseInt(sc.nextLine()));
            }

            System.out.println("Enter the number of elements: ");
            int stringSize = Integer.parseInt(sc.nextLine());

            for (int i = 0; i < stringSize; i++) {
                System.out.print("Enter string " + (i + 1) + ": ");
                task.add(objList, sc.nextLine());
            }

            System.out.println("Enter the number of objects to add: ");
            int objSize = Integer.parseInt(sc.nextLine());

            for (int i = 0; i < objSize; i++) {
                System.out.print("Enter the integer value: ");
                int intVar = Integer.parseInt(sc.nextLine());
                System.out.print("Enter the string value: ");
                String stringVar = sc.nextLine();
                task.add(objList, new CustomClass(intVar, stringVar));
            }

            System.out.println("Total size of the object list: " + task.size(objList));
        } catch (InvalidInputException e) {
            handleException(e);
        }
        finally {
			sc.close();
		}
    }
    
    
    
//Q6
    private void findIndexOf() throws InvalidInputException{
        try {
            ArrayList<String> stringList = addStrings();
            System.out.println("Enter the element you want to find the index of: ");
            String toFind = sc.nextLine();
            System.out.println("The index of " + toFind + " is: " + task.findIndexOf(stringList, toFind));
            System.out.println("The arraylist is: " + stringList + " and its size is " + task.size(stringList));
        } catch (InvalidInputException e) {
            handleException(e);
        }
    }
    
    
    
//Q7
    private void printElement()throws InvalidInputException {
        try {
            ArrayList<String> stringList = addStrings();
            Iterator<String> iterator = stringList.iterator();
            while (iterator.hasNext()) {
                System.out.println(iterator.next());
            }
        } catch (InvalidInputException e) {
            handleException(e);
        }
    }
    
    
    
//Q8
    private void findElementAtIndex()throws InvalidInputException {
        try {
            ArrayList<String> stringList = addStrings();
            System.out.println("Enter the index of the element: ");
            int index = Integer.parseInt(sc.nextLine());
            System.out.println(task.findElementAt(stringList, index));
        } catch (InvalidInputException e) {
            handleException(e);
        }
    }
    
    
    
//Q9
    public void findIndexOfDuplicate() throws InvalidInputException{
        try {
            ArrayList<String> stringList = addStrings();
            System.out.println("Enter the element you want to find the first and last index of: ");
            String toFind = sc.nextLine();
            System.out.println("The first and last index of " + toFind + " is: " + task.findIndexOf(stringList, toFind)
                    + " and " + task.lastIndexOf(stringList, toFind));
        } catch (InvalidInputException e) {
            handleException(e);
        }
    }
    
    
    
//Q10
    public void insertInBetween()throws InvalidInputException {
        try {
            ArrayList<String> stringList = addStrings();
            System.out.println("Enter the element you want to insert: ");
            String toInsert = sc.nextLine();
            System.out.println("Enter the position you want to insert at: ");
            int pos = Integer.parseInt(sc.nextLine());
            task.insertInBetween(stringList, toInsert, pos);
            System.out.println(stringList);
        } catch (InvalidInputException e) {
            handleException(e);
        }
    }
    
    //Q11
    public void createSubArrayList() throws InvalidInputException {
    	ArrayList<String> stringList = addStrings();
    	System.out.println("Enter the first position:");
    	int start = Integer.parseInt(sc.nextLine());
    	
    	System.out.println("Enter the end position:");
    	int end = Integer.parseInt(sc.nextLine());
    	
    	task.createSubArrayList(stringList, start, end);
    	
    	System.out.println("After merging: " + stringList);
    }
    
    
    
//Q12
    private void mergeList()throws InvalidInputException {
        try {
            ArrayList<String> list1 = addStrings();
            ArrayList<String> list2 = addStrings();
            ArrayList<String> finalList =(ArrayList) task.getArrayList();
            task.mergeList(list1, list2, finalList);
            System.out.println("After merging: " + finalList);
        } catch (InvalidInputException e) {
            handleException(e);
        }
    }

    
    //Q13
    private void mergeListRev()throws InvalidInputException {
        try {
            ArrayList<String> list1 = addStrings();
            ArrayList<String> list2 = addStrings();
            ArrayList<String> finalList =(ArrayList) task.getArrayList();
            task.mergeListRev(list1, list2, finalList);
            System.out.println("After merging: " + finalList);
        } catch (InvalidInputException e) {
            handleException(e);
        }
    }
    
    

    //Q14
    private void createWithDecimal() throws InvalidInputException{
        try {
            ArrayList<Double> doubleList = new ArrayList<>();
            System.out.println("Enter the number of elements: ");
            int size = Integer.parseInt(sc.nextLine());

            for (int i = 0; i < size; i++) {
                System.out.print("Enter Decimal " + (i + 1) + ": ");
                task.add(doubleList, sc.nextDouble());
            }

            System.out.println("The array list is: " + doubleList + " and its size is " + task.size(doubleList));
        } catch (InvalidInputException e) {
            handleException(e);
        }
    }

    
    //Q15
    public void removeCommonElements() throws InvalidInputException{
        try {
            ArrayList<String> stringList = addStrings();
            System.out.println("How many elements to copy: ");
            int num = Integer.parseInt(sc.nextLine());
            task.removeCommonElements(stringList, num);
        } catch (InvalidInputException e) {
            handleException(e);
        }
    }

    
    //Q16
    public void retainCommonElements() throws InvalidInputException{
        try {
            ArrayList<String> stringList = addStrings();
            System.out.println("How many elements to retain: ");
            int num = Integer.parseInt(sc.nextLine());
             task.retainCommonElements(stringList, num);
            
        } catch (InvalidInputException e) {
            handleException(e);
        }
    }
    
    
  //Q17
    public void removeAllFloat() throws InvalidInputException{
        try {
            ArrayList<Float> floatList = new ArrayList<>();
            System.out.println("Enter the number of elements: ");
            int size = Integer.parseInt(sc.nextLine());

            for (int i = 0; i < size; i++) {
                System.out.print("Enter Decimal " + (i + 1) + ": ");
                task.add(floatList, sc.nextFloat());
            }

            task.removeAll(floatList);
            System.out.println("The length after removing: " + task.size(floatList));
        } catch (InvalidInputException e) {
            handleException(e);
        }
    }
    
    
    
    
  //Q18
    public void isPresent()throws InvalidInputException {
        try {
            ArrayList<String> stringList = addStrings();
            System.out.println("Enter the string to check: ");
            String toCheck = sc.nextLine();
            System.out.println(task.isPresent(stringList, toCheck));
        } catch (InvalidInputException e) {
            handleException(e);
        }
    }


    private static void handleException(Exception e) throws InvalidInputException {
    	throw new InvalidInputException(e.getMessage(), e);
    }
}
