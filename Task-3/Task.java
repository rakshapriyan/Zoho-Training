import java.util.Arrays;

public class Task{
	
	public static void checklength(CharSequence s) throws NullStringException{
		if(s == null || s.length() == 0){
			throw new NullStringException("String cannot be Null or Empty");
		}
	}
	
	// Q1 -> Finding length
	public static int length(String s) throws NullStringException{
		checklength(s);
		return s.length();
	}
	
	
	// Q2 -> converting into char array
	public static char[] convertToCharArray(String s) throws NullStringException{
		checklength(s);
		return s.toCharArray();
	}
	
	//Q3 -> Finding pen ultimate Character
	public static char findPenUltimateCharacter(String s) throws NullStringException{
		checklength(s);
		return s.charAt(s.length() - 2);
	}
	
	//Q4 -> Finding Occurances of a Character
	public static int findOccurances(String s, char c) throws NullStringException{
		checklength(s);
		int initialLength = s.length();
		String toReplace = Character.toString(c);
		return initialLength - s.replace(toReplace,"").length();
	}
	
	//Q5 -> Finding the greatest position
	
	public static int greatestPosition(String s, char c) throws NullStringException{
		checklength(s);
		int l = s.length()-1;
		for(int i = l; i>=0; i--){
			if(s.charAt(i)==c){
				return i;
			}
		}
		return -1;
	} 
	
	//Q6 -> last 5 characters of a string
	public static String last5Characters(String s) throws NullStringException{
		checklength(s);
		int l = s.length();
		if(l<5){
			return "The length of String is less than 5.";
		}
		return s.substring(l-5, l);
	}
	
	// Q7 -> First 3 characters
	public static String first3Characters(String s) throws NullStringException{
		checklength(s);
		if(s.length()<3){
			return "The length of String is less than 3.";
		}
		return s.substring(0, 3);
	}
	
	// Q8 -> Replace first 3 characters with XYZ
	
	public static String ReplacewithXYZ(String s)  throws NullStringException{
		checklength(s);
		if(s.length()<3){
			return "XYZ";
		}
		return "XYZ"+s.substring(3,s.length());
	}
	
	// Q9 -> To check whether a string starts with "ent"\
	
	public static boolean startswithent(String s) throws NullStringException{
		
		checklength(s);
		return s.startsWith("ent");
	}
	
	// Q10 -> To check whether a string ends with "le"\
	
	public static boolean endswithle(String s) throws NullStringException{
		
		checklength(s);
		return s.endsWith("le");
	}
	
	// Q11 -> lowercase to uppercase
	
	public static String convertToUppercase(String s) throws NullStringException{
		checklength(s);
		return s.toUpperCase();
	}
	
	// Q12 ->  uppercase to lowercase  
	
	public static String convertToLowerCase(String s) throws NullStringException{
		checklength(s);
		return s.toLowerCase();
	}
	
	// Q13 -> To reverse a string
	
	public static String reverse(String s) throws NullStringException{
		checklength(s);
		int l = s.length()-1;
		String ans = "";
		for(int i = l; i>=0; i--){
			ans+=s.charAt(i);
		}
		
		return ans;
	}
	
	
	// Q14 -> Concatenate multiple strings
	public static String Concatenate(String s) throws NullStringException{
		checklength(s);
		return s;
		
	}
	
	// Q14, 15 -> Concatenate multiple strings and remove space
	public static String ConcatenateandRemoveSpace(String s) throws NullStringException{
		checklength(s);
		return s.replace(" ", "");
		
	}
	
	// Q16 -> Concatenate multiple strings
	public static String toArray(String s) throws NullStringException{
		checklength(s);
		String arr[] = s.split(" ");
		return Arrays.toString(arr);
		
	}
	
	// Q17 -> merge with -
	public static String mergebetween(String s)throws NullStringException{
		checklength(s);
		return s.replace(" ","-");
	}
	
	// Q18 Check 2 string equals - Case Sensitive
	
	public static boolean checkwithCase(String s1, String s2)throws NullStringException{
		checklength(s1);
		checklength(s2);
		return s1.equals(s2);
	}
	
	// Q19 -> Check 2 String equals - Case insensitive
	
	public static boolean checkwithoutCase(String s1, String s2)throws NullStringException{
		checklength(s1);
		checklength(s2);
		return s1.equalsIgnoreCase(s2);
	}
	
	// Q20 -> Removing spaces from the String
	
	public static String trim(String s)throws NullStringException{
		checklength(s);
		return s.trim();
	}
	
}
