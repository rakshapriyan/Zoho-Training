import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;

public class Runner {
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String testString = "";
        String testString2 = "";
        char testChar;
        int option;

        while (true) {
            try {
            	System.out.println("\n");
                System.out.println("Select an option:");
                System.out.println("1. Length of a string");
                System.out.println("2. Convert to char array");
                System.out.println("3. Find penultimate character");
                System.out.println("4. Find occurrences of a character");
                System.out.println("5. Find greatest position of a character");
                System.out.println("6. Last 5 characters of a string");
                System.out.println("7. First 3 characters of a string");
                System.out.println("8. Replace first 3 characters with XYZ");
                System.out.println("9. Check if string starts with 'ent'");
                System.out.println("10. Check if string ends with 'le'");
                System.out.println("11. Convert to uppercase");
                System.out.println("12. Convert to lowercase");
                System.out.println("13. Reverse the string");
                System.out.println("14. Concatenate (original string)");
                System.out.println("15. Concatenate and remove spaces");
                System.out.println("16. Convert to array format");
                System.out.println("17. Merge with '-'");
                System.out.println("18. Check if two strings are equal (case sensitive)");
                System.out.println("19. Check if two strings are equal (case insensitive)");
                System.out.println("20. Remove spaces from the string");
                System.out.println("21. Exit");

                option = Integer.parseInt(br.readLine());

                if (option == 21) {
                    System.out.println("Exiting...");
                    break;
                }

                switch (option) {
                    case 1:
                        System.out.print("Enter a string: ");
                        testString = br.readLine();
                        System.out.println("Length: " + Task.length(testString));
                        break;

                    case 2:
                        System.out.print("Enter a string: ");
                        testString = br.readLine();
                        System.out.println("Char Array: " + Arrays.toString(Task.convertToCharArray(testString)));
                        break;

                    case 3:
                        System.out.print("Enter a string: ");
                        testString = br.readLine();
                        System.out.println("Penultimate Character: " + Task.findPenUltimateCharacter(testString));
                        break;

                    case 4:
                        System.out.print("Enter a string: ");
                        testString = br.readLine();
                        System.out.print("Enter a character: ");
                        testChar = (char) br.read();
                        br.readLine(); // Consume newline character
                        System.out.println("Occurrences of '" + testChar + "': " + Task.findOccurances(testString, testChar));
                        break;

                    case 5:
                        System.out.print("Enter a string: ");
                        testString = br.readLine();
                        System.out.print("Enter a character: ");
                        testChar = (char) br.read();
                        br.readLine(); // Consume newline character
                        System.out.println("Greatest Position: " + Task.greatestPosition(testString, testChar));
                        break;

                    case 6:
                        System.out.print("Enter a string: ");
                        testString = br.readLine();
                        System.out.println("Last 5 Characters: " + Task.last5Characters(testString));
                        break;

                    case 7:
                        System.out.print("Enter a string: ");
                        testString = br.readLine();
                        System.out.println("First 3 Characters: " + Task.first3Characters(testString));
                        break;

                    case 8:
                        System.out.print("Enter a string: ");
                        testString = br.readLine();
                        System.out.println("Replaced String: " + Task.ReplacewithXYZ(testString));
                        break;

                    case 9:
                        System.out.print("Enter a string: ");
                        testString = br.readLine();
                        System.out.println("Starts with 'ent': " + Task.startswithent(testString));
                        break;

                    case 10:
                        System.out.print("Enter a string: ");
                        testString = br.readLine();
                        System.out.println("Ends with 'le': " + Task.endswithle(testString));
                        break;

                    case 11:
                        System.out.print("Enter a string: ");
                        testString = br.readLine();
                        System.out.println("Uppercase: " + Task.convertToUppercase(testString));
                        break;

                    case 12:
                        System.out.print("Enter a string: ");
                        testString = br.readLine();
                        System.out.println("Lowercase: " + Task.convertToLowerCase(testString));
                        break;

                    case 13:
                        System.out.print("Enter a string: ");
                        testString = br.readLine();
                        System.out.println("Reversed String: " + Task.reverse(testString));
                        break;

                    case 14:
                        System.out.print("Enter a string: ");
                        testString = br.readLine();
                        System.out.println("Concatenated String: " + Task.Concatenate(testString));
                        break;

                    case 15:
                        System.out.print("Enter a string: ");
                        testString = br.readLine();
                        System.out.println("Concatenated and Removed Spaces: " + Task.ConcatenateandRemoveSpace(testString));
                        break;

                    case 16:
                        System.out.print("Enter a string: ");
                        testString = br.readLine();
                        System.out.println("Array Format: " + Task.toArray(testString));
                        break;

                    case 17:
                        System.out.print("Enter a string: ");
                        testString = br.readLine();
                        System.out.println("Merged with '-': " + Task.mergebetween(testString));
                        break;

                    case 18:
                        System.out.print("Enter first string: ");
                        testString = br.readLine();
                        System.out.print("Enter second string: ");
                        testString2 = br.readLine();
                        System.out.println("Strings equal (case sensitive): " + Task.checkwithCase(testString, testString2));
                        break;

                    case 19:
                        System.out.print("Enter first string: ");
                        testString = br.readLine();
                        System.out.print("Enter second string: ");
                        testString2 = br.readLine();
                        System.out.println("Strings equal (case insensitive): " + Task.checkwithoutCase(testString, testString2));
                        break;

                    case 20:
                        System.out.print("Enter a string: ");
                        testString = br.readLine();
                        System.out.println("Trimmed String: " + Task.trim(testString));
                        break;

                    default:
                        System.out.println("Invalid option. Please try again.");
                        break;
                }
            } catch (IOException | NullStringException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }
}

