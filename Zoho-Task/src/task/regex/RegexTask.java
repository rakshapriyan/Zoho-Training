package task.regex;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexTask {

	
	private static final String MOBILE_NUMBER_PATTERN = "^[6789]\\d{9}$";
	private static final String ALPHANUMERIC_PATTERN = "^[a-zA-Z0-9]+$";
	private static final String EMAIL_PATTERN = "^[^@\\s]+@[^@\\s]+\\.[^@\\s]+$";
	private static final String HTML_TAG_PATTERN = "<[^>]+>";
	
	public boolean validateMobileNumber(String mobileNumber) {
        return Pattern.matches(MOBILE_NUMBER_PATTERN, mobileNumber);
    }
	
	public boolean validateAlphanumericString(String input) { 
	    return Pattern.matches(ALPHANUMERIC_PATTERN, input);
	}
	
	
	public boolean startsWith(String str1, String str2) {
		return Pattern.matches("^"+Pattern.quote(str1)+".*", str2);
	}
	
	public boolean contains(String str1, String str2) {
		return Pattern.compile(Pattern.quote(str1)).matcher(str2).find();
	}
	
	public boolean endsWith(String str1, String str2) {
		return Pattern.matches(".*"+Pattern.quote(str1)+"$", str2);
	}
	
	public boolean equals(String str1, String str2) {
		return Pattern.matches(Pattern.quote(str1), str2);
	}
	
	public List<Boolean> matches(List<String> list, String pat){
		List<Boolean> ans = new ArrayList<>();
		Pattern pattern = Pattern.compile(Pattern.quote(pat), Pattern.CASE_INSENSITIVE);
		for(String s : list) {
			ans.add(pattern.matcher(s).find());
		}
		return ans;
	}
	
	
	
	public boolean validateEmail(String email) {
		return Pattern.matches(EMAIL_PATTERN, email);
	}
	
	public List<Boolean> checkLength(List<String> list, int start, int end){
		String regex = "^.{" + start + "," + end + "}$";
		Pattern pattern = Pattern.compile(regex);
		List<Boolean> ans = new ArrayList<>();
		for(String s : list) {
			ans.add(pattern.matcher(s).matches());
		}
		
		
		return ans;
	}
	
	public Map<String, Integer> contains(List<String> list1, List<String> list2) {
		Map<String, Integer> resultMap = new HashMap<>();
		for (String s : list2) {
            Pattern pattern = Pattern.compile(Pattern.quote(s));
            for (int i = 0; i < list1.size(); i++) {
                if (pattern.matcher(list1.get(i)).matches()) {
                    resultMap.put(s, i); 
                    break;
                }
            }
        }
		
		return resultMap;
	}
	
	public static List<String> extractHTMLTags(String htmlString) {
        List<String> tagsList = new ArrayList<>();


        Matcher matcher = Pattern.compile(HTML_TAG_PATTERN).matcher(htmlString);

        while (matcher.find()) {
            tagsList.add(matcher.group());
        }

        return tagsList;
    }
}
