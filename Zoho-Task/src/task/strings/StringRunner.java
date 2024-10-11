package task.strings;

import java.util.Arrays;
import java.util.Scanner;

import task.exception.InvalidInputException;

public class StringRunner{
	private static StringTask task = new StringTask(); 
	private static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        String testString = "";
        String testString2 = "";
        char testChar;
        int option, numberOfCharacters;

        while (true) {
            try {
                System.out.println("\n");
                System.out.println("Select an option:");
                System.out.println("1. Length of a string");
                System.out.println("2. Convert to char array");
                System.out.println("3. Find character at position");
                System.out.println("4. Count occurrences of a character");
                System.out.println("5. Find greatest position of a character");
                System.out.println("6. Get last N characters");
                System.out.println("7. Get first N characters");
                System.out.println("8. Replace first N characters with given string");
                System.out.println("9. Check if string starts with given prefix");
                System.out.println("10. Check if string ends with given suffix");
                System.out.println("11. Convert to uppercase");
                System.out.println("12. Convert to lowercase");
                System.out.println("13. Reverse the string");
                System.out.println("14. Concatenate string array with a word");
                System.out.println("15. Concatenate string array and remove spaces");
                System.out.println("16. Convert string to array of words");
                System.out.println("17. Replace with given string");
                System.out.println("18. Check if two strings are equal (case sensitive)");
                System.out.println("19. Check if two strings are equal (case insensitive)");
                System.out.println("20. Remove spaces from both end of the string");
                System.out.println("21. Exit");

                option = Integer.parseInt(sc.nextLine());

                if (option == 21) {
                    System.out.println("Exiting...");
                    break;
                }

                switch (option) {
                    case 1:
                        try {
                            testString = args[0];
                            System.out.println("Length: " + task.length(testString));
                        } catch (InvalidInputException e) {
                            handleException(e);
                        }
                        break;

                    case 2:
                        try {
                            System.out.print("Enter a string: ");
                            testString = sc.nextLine();
                            System.out.println("Char Array: " + Arrays.toString(task.convertToCharArray(testString)));
                        } catch (InvalidInputException e) {
                        	
                            handleException(e);
                        }
                        break;
                        
                        
                        

                    case 3:
                        try {
                            System.out.print("Enter a string: ");
                            testString = sc.nextLine();
                            System.out.print("Enter index: ");
                            int index = Integer.parseInt(sc.nextLine());
                            System.out.println("Character at position " + index + ": " + task.findCharacterAtPosition(testString, index));
                        } catch (InvalidInputException e) {
                            handleException(e);
                        }
                        break;
                        
                        
                        
                        

                    case 4:
                        try {
                            System.out.print("Enter a string: ");
                            testString = sc.nextLine();
                            System.out.print("Enter a character: ");
                            testChar = sc.nextLine().charAt(0);
                            System.out.println("Occurrences of '" + testChar + "': " + task.countCharacterOccurrences(testString, testChar));
                        } catch (InvalidInputException e) {
                            handleException(e);
                        }
                        break;

                    case 5:
                        try {
                            System.out.print("Enter a string: ");
                            testString = sc.nextLine();
                            System.out.print("Enter a character: ");
                            testChar = sc.nextLine().charAt(0);
                            System.out.println("Greatest Position: " + task.findGreatestPosition(testString, testChar));
                        } catch (InvalidInputException e) {
                            handleException(e);
                        }
                        break;

                    case 6:
                        try {
                            System.out.print("Enter a string: ");
                            testString = sc.nextLine();
                            System.out.print("Enter number of characters: ");
                            numberOfCharacters = Integer.parseInt(sc.nextLine());
                            System.out.println("Last " + numberOfCharacters + " Characters: " + task.getLastNCharacters(testString, numberOfCharacters));
                        } catch (InvalidInputException e) {
                            handleException(e);
                        }
                        break;

                    case 7:
                        try {
                            System.out.print("Enter a string: ");
                            testString = sc.nextLine();
                            System.out.print("Enter number of characters: ");
                            numberOfCharacters = Integer.parseInt(sc.nextLine());
                            System.out.println("First " + numberOfCharacters + " Characters: " + task.getFirstNCharacters(testString, numberOfCharacters));
                        } catch (InvalidInputException e) {
                            handleException(e);
                        }
                        break;

                    case 8:
                        try {
                            System.out.print("Enter a string: ");
                            testString = sc.nextLine();
                            System.out.print("Enter number of characters: ");
                            numberOfCharacters = Integer.parseInt(sc.nextLine());
                            System.out.print("Enter replacement string: ");
                            String toReplace = sc.nextLine();
                            System.out.println("Replaced String: " + task.replaceFirstNCharactersWith(testString, numberOfCharacters, toReplace));
                        } catch (InvalidInputException e) {
                            handleException(e);
                        }
                        break;

                    case 9:
                        try {
                            System.out.print("Enter a string: ");
                            testString = sc.nextLine();
                            System.out.print("Enter prefix: ");
                            String prefix = sc.nextLine();
                            System.out.println("Starts with '" + prefix + "': " + task.startsWith(testString, prefix));
                        } catch (InvalidInputException e) {
                            handleException(e);
                        }
                        break;

                    case 10:
                        try {
                            System.out.print("Enter a string: ");
                            testString = sc.nextLine();
                            System.out.print("Enter suffix: ");
                            String suffix = sc.nextLine();
                            System.out.println("Ends with '" + suffix + "': " + task.endsWith(testString, suffix));
                        } catch (InvalidInputException e) {
                            handleException(e);
                        }
                        break;

                    case 11:
                        try {
                            System.out.print("Enter a string: ");
                            testString = sc.nextLine();
                            System.out.println("Uppercase: " + task.convertToUpperCase(testString));
                        } catch (InvalidInputException e) {
                            handleException(e);
                        }
                        break;

                    case 12:
                        try {
                            System.out.print("Enter a string: ");
                            testString = sc.nextLine();
                            System.out.println("Lowercase: " + task.convertToLowerCase(testString));
                        } catch (InvalidInputException e) {
                            handleException(e);
                        }
                        break;

                    case 13:
                        try {
                            System.out.print("Enter a string: ");
                            testString = sc.nextLine();
                            System.out.println("Reversed String: " + task.reverse(testString));
                        } catch (InvalidInputException e) {
                            handleException(e);
                        }
                        break;

                    case 14:
                        try {
                            System.out.print("Enter the number of strings to concatenate: ");
                            int size = Integer.parseInt(sc.nextLine());
                            String[] arr = new String[size];
                            for (int i = 0; i < size; i++) {
                                System.out.print("Enter string " + (i + 1) + ": ");
                                arr[i] = sc.nextLine();
                            }
                            System.out.print("Enter string to join with: ");
                            String joinWith = sc.nextLine();
                            System.out.println("Concatenated String: " + task.concatenateArray(joinWith, arr));
                        } catch (InvalidInputException e) {
                            handleException(e);
                        }
                        break;

                    case 15:
                        try {
                            System.out.print("Enter the number of strings to concatenate: ");
                            int size = Integer.parseInt(sc.nextLine());
                            String[] arr = new String[size];
                            for (int i = 0; i < size; i++) {
                                System.out.print("Enter string " + (i + 1) + ":");
                                arr[i] = sc.nextLine();
                            }
                            
                            System.out.println("Concatenated and Removed Spaces: " + task.concatenateArray("", arr));
                        } catch (InvalidInputException e) {
                            handleException(e);
                        }
                        break;

                    case 16:
                        try {
                            System.out.print("Enter a string: ");
                            testString = sc.nextLine();
                            System.out.print("Enter the word wanna split with: ");
                            String splitWith = sc.nextLine();
                            System.out.println("Array of Words: " + Arrays.toString(task.toArray(testString, splitWith)));
                        } catch (InvalidInputException e) {
                            handleException(e);
                        }
                        break;

                    case 17:
                        try {
                            System.out.print("Enter a string: ");
                            testString = sc.nextLine();
                            System.out.print("Enter string to remove: ");
                            String toRemove = sc.nextLine();
                            System.out.print("Enter replacement string: ");
                            String toReplace = sc.nextLine();
                            System.out.println("Replaced String: " + task.replaceWith(testString, toRemove, toReplace));
                        } catch (InvalidInputException e) {
                            handleException(e);
                        }
                        break;

                    case 18:
                        try {
                            System.out.print("Enter first string: ");
                            testString = sc.nextLine();
                            System.out.print("Enter second string: ");
                            testString2 = sc.nextLine();
                            System.out.println("Strings equal (case sensitive): " + task.equalsCaseSensitive(testString, testString2));
                        } catch (InvalidInputException e) {
                            handleException(e);
                        }
                        break;

                    case 19:
                        try {
                            System.out.print("Enter first string: ");
                            testString = sc.nextLine();
                            System.out.print("Enter second string: ");
                            testString2 = sc.nextLine();
                            System.out.println("Strings equal (case insensitive): " + task.equalsIgnoreCase(testString, testString2));
                        } catch (InvalidInputException e) {
                            handleException(e);
                        }
                        break;

                    case 20:
                        try {
                            System.out.print("Enter a string: ");
                            testString = sc.nextLine();
                            System.out.println("Trimmed String: " + task.removeSpaces(testString));
                        } catch (InvalidInputException e) {
                            handleException(e);
                        }
                        break;

                    default:
                        System.out.println("Invalid option. Please try again.");
                        break;
                }

            } catch (NumberFormatException e) {
                System.out.println("Invalid number format. Please enter valid numbers.");
             
            } catch (InvalidInputException e){
            	System.out.println("Caused by:     "+e.getCause().getClass().getName());
            	System.out.println(e.getMessage());
            	e.printStackTrace();
            }
            finally{
            	sc.close();
            }
        }
        
    }

    private static void handleException(Exception e) throws InvalidInputException {
    	throw new InvalidInputException(e.getMessage(), e);
    }
    
   

}

