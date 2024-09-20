package task.strings;

import task.exception.InvalidInputException;
import task.util.HelperUtil;

public class StringTask {
    

    // Q1 -> Finding length
    public int length(String str) throws InvalidInputException {
        HelperUtil.isNull(str);
        return str.length();
    }
    
    
    

    // Q2 -> Converting into char array
    public char[] convertToCharArray(String str) throws InvalidInputException {
        HelperUtil.isNull(str);
        return str.toCharArray();
    }
    
    
    

    // Q3 -> Finding the character present at given index
    public char findCharacterAtPosition(String str, int index) throws InvalidInputException { 
    	int length = length(str);		
        HelperUtil.validateBoundary(length, index);
        return str.charAt(index);
    }
    
    
    

    // Q4 -> Finding occurrences of a character
    public int countCharacterOccurrences(String str, char character) throws InvalidInputException {
        HelperUtil.isNull(str);
        int countOfCharacter = 0;
        for(char c : str.toCharArray()){
        	if(c == character){
        	countOfCharacter++;
           	}
        }
        return countOfCharacter;
    }
    
    
    

    // Q5 -> Finding the greatest position of a character
    public int findGreatestPosition(String str, char character) throws InvalidInputException {
        HelperUtil.isNull(str);
        return str.lastIndexOf(character);
    }
    
    
    

    // Q6 -> Getting the last N characters of a string
    public String getLastNCharacters(String str, int numberOfCharacters) throws InvalidInputException {
        int length = length(str);
        HelperUtil.validateBoundary(length, numberOfCharacters);
        
        return str.substring(length - numberOfCharacters);
    }
    
    
    

    // Q7 -> Getting the first N characters
    public String getFirstNCharacters(String str, int numberOfCharacters) throws InvalidInputException {

        
        int length = length(str);
        HelperUtil.validateBoundary(length, numberOfCharacters);
        
        return str.substring(0, numberOfCharacters);
    }
    
    
    
    

     // Q8 -> Replacing the first N characters with given string
     public String replaceFirstNCharactersWith(String str, int numberOfCharacters, String toReplace) throws InvalidInputException {
        int length = length(str);
        HelperUtil.isNull(toReplace);
        HelperUtil.validateBoundary(length, numberOfCharacters);
        
        return toReplace + str.substring(numberOfCharacters);
    }





    // Q9 -> Checking if a string starts with the given prefix
    public boolean startsWith(String str, String prefix) throws InvalidInputException {
        HelperUtil.isNull(str);
        HelperUtil.isNull(prefix);
        return str.startsWith(prefix);
    }
    
    
    
    
    

    // Q10 -> Checking if a string ends with the given suffix
    public boolean endsWith(String str, String suffix) throws InvalidInputException {
        HelperUtil.isNull(str);
        HelperUtil.isNull(suffix);
        return str.endsWith(suffix);
    }




    // Q11 -> Converting string to uppercase
    public String convertToUpperCase(String str) throws InvalidInputException {
        HelperUtil.isNull(str);
        return str.toUpperCase();
    }
    
    
    
    

    // Q12 -> Converting string to lowercase
    public String convertToLowerCase(String str) throws InvalidInputException {
        HelperUtil.isNull(str);
        return str.toLowerCase();
    }
        

    // Q13 -> Reversing a string
    public String reverse(String str) throws InvalidInputException {
        HelperUtil.isNull(str);
        char[] charArray = str.toCharArray();
        int left = 0;
        int right = length(str) - 1;

        while (left < right) {
            char temp = charArray[left];
            charArray[left] = charArray[right];
            charArray[right] = temp;
            left++;
            right--;
        }

        return new String(charArray);
    }
    

    
    // Q14, Q15 -> Concatenating multiple strings and removing spaces
    public String concatenateArray(String joinWith, String arr[]) throws InvalidInputException{
    	//for(String s : arr){
    	//	validateString(s);
    	//}
    	HelperUtil.isNull(joinWith);
    	return String.join(joinWith, arr);
    	
    }
    

    // Q16 -> Converting a string into an array of words
    public String[] toArray(String str, String splitWith) throws InvalidInputException {
        HelperUtil.isNull(str);
        return str.split(splitWith);
    }




    // Q17 -> Replacing With given String
    public String replaceWith(String str, String toRemove, String toReplace) throws InvalidInputException {
        HelperUtil.isNull(str);
        HelperUtil.isNull(toRemove);
        HelperUtil.isNull(toReplace);
        return str.replace(toRemove, toReplace);
    }
    
     
    

    // Q18 -> Checking if two strings are equal (case sensitive)
    public boolean equalsCaseSensitive(String str1, String str2) throws InvalidInputException {
        HelperUtil.isNull(str1);
        HelperUtil.isNull(str2);
        return str1.equals(str2);
    }
        

    // Q19 -> Checking if two strings are equal (Not case sensitive)
    public boolean equalsIgnoreCase(String str1, String str2) throws InvalidInputException {
        HelperUtil.isNull(str1);
        HelperUtil.isNull(str2);
        return str1.equalsIgnoreCase(str2);
    }
    
    
    // Q20 -> Removing given Space from both ends
    public String removeSpaces(String str) throws InvalidInputException {
        HelperUtil.isNull(str);
        return str.trim();
    }
    
    
}
