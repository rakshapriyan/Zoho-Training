package task.regex;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class RegexRunner {

    public static void main(String[] args) {
        RegexTask regexTask = new RegexTask();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("Regular Expressions Menu:");
            System.out.println("1. Mobile number validation");
            System.out.println("2. Alphanumeric string validation");
            System.out.println("3. String match operations");
            System.out.println("4. Case-insensitive list matching");
            System.out.println("5. Email validation");
            System.out.println("6. Check length of strings in a list");
            System.out.println("7. List matching and indexing");
            System.out.println("8. Extract HTML tags");
            System.out.println("9. Exit");
            System.out.print("Choose an option: ");
            
            int choice = sc.nextInt();
            sc.nextLine();  // Consume newline
            
            switch (choice) {
                case 1:
                    System.out.print("Enter mobile number: ");
                    String mobileNumber = sc.nextLine();
                    System.out.println("Valid: " + regexTask.validateMobileNumber(mobileNumber));
                    break;

                case 2:
                    System.out.print("Enter alphanumeric string: ");
                    String alphaNumeric = sc.nextLine();
                    System.out.println("Valid: " + regexTask.validateAlphanumericString(alphaNumeric));
                    break;

                case 3:
                    System.out.println("Enter first string: ");
                    String str1 = sc.nextLine();
                    System.out.println("Enter second string: ");
                    String str2 = sc.nextLine();
                    System.out.println("Starts with: " + regexTask.startsWith(str1, str2));
                    System.out.println("Contains: " + regexTask.contains(str1, str2));
                    System.out.println("Ends with: " + regexTask.endsWith(str1, str2));
                    System.out.println("Equals: " + regexTask.equals(str1, str2));
                    break;

                case 4:
                    System.out.println("Enter strings (comma separated): ");
                    String listInput = sc.nextLine();
                    List<String> stringList = Arrays.asList(listInput.split(","));
                    System.out.println("Enter matching string: ");
                    String matchingStr = sc.nextLine();
                    List<Boolean> result = regexTask.matches(stringList, matchingStr);
                    System.out.println("Matching results: " + result);
                    break;

                case 5:
                    System.out.print("Enter email: ");
                    String email = sc.nextLine();
                    System.out.println("Valid: " + regexTask.validateEmail(email));
                    break;

                case 6:
                    System.out.println("Enter strings (comma separated): ");
                    String lengthListInput = sc.nextLine();
                    List<String> lengthList = Arrays.asList(lengthListInput.split(","));
                    System.out.print("Enter start length: ");
                    int startLength = sc.nextInt();
                    System.out.print("Enter end length: ");
                    int endLength = sc.nextInt();
                    sc.nextLine(); // Consume newline
                    List<Boolean> lengthResults = regexTask.checkLength(lengthList, startLength, endLength);
                    System.out.println("Length check results: " + lengthResults);
                    break;

                case 7:
                    System.out.println("Enter List1 (comma separated): ");
                    List<String> list1 = Arrays.asList(sc.nextLine().split(","));
                    System.out.println("Enter List2 (comma separated): ");
                    List<String> list2 = Arrays.asList(sc.nextLine().split(","));
                    Map<String, Integer> matchMap = regexTask.contains(list1, list2);
                    System.out.println("Matching map: " + matchMap);
                    break;

                case 8:
                    System.out.println("Enter raw HTML string: ");
                    String htmlString = sc.nextLine();
                    List<String> tags = RegexTask.extractHTMLTags(htmlString);
                    System.out.println("Extracted tags: " + tags);
                    break;

                case 9:
                    System.out.println("Exiting...");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid option. Try again.");
            }
        }
    }
}
