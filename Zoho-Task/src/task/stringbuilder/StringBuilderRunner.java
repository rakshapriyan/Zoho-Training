package task.stringbuilder;


import java.util.Scanner;

import task.exception.InvalidInputException;

public class StringBuilderRunner {

    private static Scanner sc = new Scanner(System.in);
    private static StringBuilderTask task = new StringBuilderTask();
    private static StringBuilderRunner stringBuilderRunner = new StringBuilderRunner();
    public static void main(String[] args) {
        boolean exit = false;
        
        while (!exit) {
            
            displayOptions();
            int choice = Integer.parseInt(sc.nextLine());

            try {
                switch (choice) {
                    case 1:
                        stringBuilderRunner.printLengthAndString();
                        break;
                    case 2:
                        stringBuilderRunner.addWithDelimiter();
                        break;
                    case 3:
                        stringBuilderRunner.insertStringWithDelimiter();
                        break;
                    case 4:
                        stringBuilderRunner.deleteStringWithDelimiter();
                        break;
                    case 5:
                        stringBuilderRunner.replaceDelimiter();
                        break;
                    case 6:
                        stringBuilderRunner.reverse();
                        break;
                    case 7:
                        stringBuilderRunner.deleteAtRange();
                        break;
                    case 8:
                        stringBuilderRunner.replaceAtRange();
                        break;
                    case 9:
                        stringBuilderRunner.firstIndexOfDelimiter();
                        break;
                    case 10:
                        stringBuilderRunner.lastIndexOfDelimiter();
                        break;
                    case 11:
                        exit = true;
                        System.out.println("Exiting the program.");
                        break;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            } catch (InvalidInputException e) {
                System.out.println("Error: " + e.getMessage());
                System.out.println("Caused By: "+e.getCause().getClass().getName());
                e.printStackTrace();
            } catch (Exception e) {
                System.out.println("An unexpected error occurred: " + e.getMessage());
            }
            finally{
            	sc.close();
            }
        }
    }
    
    
    private static void displayOptions(){
    	    System.out.println("\nMenu:");
            System.out.println("1. Print Length and String");
            System.out.println("2. Add Strings with Delimiter");
            System.out.println("3. Insert in Between with Delimiter");
            System.out.println("4. Delete at Position");
            System.out.println("5. Replace Delimiter");
            System.out.println("6. Reverse String");
            System.out.println("7. Delete at Range");
            System.out.println("8. Replace at Range");
            System.out.println("9. First Index of Delimiter");
            System.out.println("10. Last Index of Delimiter");
            System.out.println("11. Exit");
            System.out.print("Enter your choice: ");
    }
    
	    // Q1
	private void printLengthAndString() throws InvalidInputException {
	    try {
		StringBuilder sb = task.getStringBuilder();
		while (true) {
		    System.out.println("Enter the String you want to find the length: ");
		    String input = sc.nextLine();
		    task.emptyAndAppend(sb, input);

		    System.out.println("The length for \"" + sb + "\" is " + task.length(sb));
		    System.out.println("Do you want to check for another String (y/N): ");
		    String inp = sc.nextLine();
		    if (inp.equalsIgnoreCase("N")) {
		        break;
		    }
		}
	    } catch (InvalidInputException e) {
		handleException(e);
	    }
	}

	// Q2
	private void addWithDelimiter() throws InvalidInputException {
	    try {
		StringBuilder sb = task.getStringBuilder();
		System.out.println("Enter the Initial String: ");
		String input = sc.nextLine();
		task.append(sb, input);
		System.out.println("The length for \"" + sb + "\" is " + task.length(sb));
		System.out.println("Number of elements needed to append: ");
		int size = Integer.parseInt(sc.nextLine());
		String[] arr = getArrayInput(size);
		String delimiter = getDelimiter();
		task.joinStringArrayWithString(sb, delimiter, arr);
		System.out.println("The length for \"" + sb + "\" is " + sb.length());
	    } catch (InvalidInputException e) {
		handleException(e);
	    }
	}
	
	
	//Q3
	private void insertStringWithDelimiter()throws InvalidInputException {
		try {
		StringBuilder sb = task.getStringBuilder();
		System.out.println("Number of elements needed to add: ");
		int size = Integer.parseInt(sc.nextLine());
		String[] arr = getArrayInput(size);
		String delimiter = getDelimiter();
		task.joinStringArrayWithDelimiter(sb, delimiter, arr);
		System.out.println("The length for \"" + sb + "\" is " + task.length(sb));
		
		System.out.println("Enter the String you want to insert: ");
		String insertString = sc.nextLine();
		
		System.out.println("Enter the position you want to insert: ");
		int insertPos = Integer.parseInt(sc.nextLine());
		
		task.insertInBetweenWithDelimiter(sb,delimiter, insertString, insertPos, size);
		System.out.println("The length for \"" + sb + "\" is " + task.length(sb));
		
	    } catch (InvalidInputException e) {
		handleException(e);
	    }
	}
	
	
	
	//Q4
	private void deleteStringWithDelimiter()  throws InvalidInputException {
		try {
		StringBuilder sb = task.getStringBuilder();
		System.out.println("Number of elements needed to add: ");
		int size = Integer.parseInt(sc.nextLine());
		String[] arr = getArrayInput(size);
		String delimiter = getDelimiter();
		task.joinStringArrayWithDelimiter(sb, delimiter, arr);
		System.out.println("The length for \"" + sb + "\" is " + task.length(sb));
		
		
		System.out.println("Enter the position you want to delete: ");
		int deletePos = Integer.parseInt(sc.nextLine());
		
		task.deleteAtPosition(sb, deletePos, delimiter, size);
		System.out.println("The length for \"" + sb + "\" is " + task.length(sb));
		
	    } catch (InvalidInputException e) {
		handleException(e);
	    }
	}
	
	

	// Q5
	private void replaceDelimiter()throws InvalidInputException  {
	    try {
		StringBuilder sb = task.getStringBuilder();
		System.out.println("Number of elements needed to add: ");
		int size = Integer.parseInt(sc.nextLine());
		String[] arr = getArrayInput(size);
		String delimiter = getDelimiter();
		task.joinStringArrayWithDelimiter(sb, delimiter, arr);
		System.out.println("The length for \"" + sb + "\" is " + task.length(sb));
		System.out.println("Enter the Replacing Delimiter String: ");
		String replaceString = sc.nextLine();
		System.out.println("String after replacing: " + task.replaceDelimiter(sb, replaceString, delimiter));
	    } catch (InvalidInputException e) {
		handleException(e);
	    }
	}

	// Q6
	private void reverse() throws InvalidInputException {
	    try {
		StringBuilder sb = task.getStringBuilder();
		System.out.println("Number of elements needed to add: ");
		int size = Integer.parseInt(sc.nextLine());
		String[] arr = getArrayInput(size);
		String delimiter = getDelimiter();
		task.joinStringArrayWithDelimiter(sb, delimiter, arr);
		System.out.println("The length for \"" + sb + "\" is " + task.length(sb));
		System.out.println("Reverse of the String is: " + task.reverse(sb));
	    } catch (InvalidInputException e) {
		handleException(e);
	    }
	}

	// Q7
	private void deleteAtRange()throws InvalidInputException  {
	    try {
		StringBuilder sb = task.getStringBuilder();
		System.out.println("Enter the String: ");
		String input = sc.nextLine();
		task.append(sb, input);
		System.out.println("The length for \"" + sb + "\" is " + task.length(sb));
		System.out.println("Enter the Starting index: ");
		int start = Integer.parseInt(sc.nextLine());
		System.out.println("Enter the Ending index: ");
		int end = Integer.parseInt(sc.nextLine());
		System.out.println("After Deleting" + task.deleteAtRange(sb, start, end));
	    } catch (InvalidInputException e) {
		handleException(e);
	    }
	}

	// Q8
	private  void replaceAtRange() throws InvalidInputException {
	    try {
		StringBuilder sb = task.getStringBuilder();
		System.out.println("Enter the String: ");
		String input = sc.nextLine();
		task.append(sb, input);
		System.out.println("The length for \"" + sb + "\" is " + task.length(sb));
		System.out.println("Enter the Starting index: ");
		int start = Integer.parseInt(sc.nextLine());
		System.out.println("Enter the Ending index: ");
		int end = Integer.parseInt(sc.nextLine());
		System.out.println("Enter the String wanted to be replaced: ");
		String word = sc.nextLine();
		System.out.println("Enter the replacement String: ");
		String replace = sc.nextLine();
		System.out.println("After Replacing" + task.replaceAtRange(sb, word, start, end, replace));
	    } catch (InvalidInputException e) {
		handleException(e);
	    }
	}

	// Q9
	private void firstIndexOfDelimiter() throws InvalidInputException {
	    try {
		StringBuilder sb = task.getStringBuilder();
		System.out.println("Number of elements needed to add: ");
		int size = Integer.parseInt(sc.nextLine());
		String[] arr = getArrayInput(size);
		String delimiter = getDelimiter();
		task.joinStringArrayWithDelimiter(sb, delimiter, arr);
		System.out.println("The length for \"" + sb + "\" is " + task.length(sb));
		System.out.println("The first index of " + delimiter + ": " + task.firstIndexOfDelimiter(sb, delimiter));
	    } catch (InvalidInputException e) {
		handleException(e);
	    }
	}

	// Q10
	private  void lastIndexOfDelimiter() throws InvalidInputException {
	    try {
		StringBuilder sb = task.getStringBuilder();
		System.out.println("Number of elements needed to add: ");
		int size = Integer.parseInt(sc.nextLine());
		String[] arr = getArrayInput(size);
		String delimiter = getDelimiter();
		task.joinStringArrayWithDelimiter(sb, delimiter, arr);
		System.out.println("The length for \"" + sb + "\" is " + task.length(sb));
		System.out.println("The last index of " + delimiter + ": " + task.lastIndexOfDelimiter(sb, delimiter));
	    } catch (InvalidInputException e) {
		handleException(e);
	    }
	}
	
	
    private void handleException(Exception e) throws InvalidInputException {
    	throw new InvalidInputException(e.getMessage(), e);
    }
    
    
    private String[] getArrayInput(int size){
    	String[] arr = new String[size];
		for (int i = 0; i < size; i++) {
		    System.out.print("Enter string " + (i + 1) + ": ");
		    arr[i] = sc.nextLine();
		}
	return arr;
    }
    
    
    private String getDelimiter(){
    	System.out.println("Enter the Delimiter String: ");
	return sc.nextLine();
    }
	    
    
    
        
}

