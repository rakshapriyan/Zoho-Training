package task.stringbuilder;

import task.exception.InvalidInputException;
import task.util.HelperUtil;

public class StringBuilderTask {
   
   
   
   public StringBuilder getStringBuilder() throws InvalidInputException{
   	
   	return new StringBuilder();
   }
    
    
    // Length of the StringBuilder
    public int length(StringBuilder sb) throws InvalidInputException {
    	HelperUtil.isNull(sb);
        return sb.length();
    }
    
    
    // Append to the StringBuilder
    public StringBuilder append(StringBuilder sb, String str) throws InvalidInputException {
    	HelperUtil.isNull(sb);
    	HelperUtil.isNull(str);
        return sb.append(str);
    }
    
    

    // Empty the StringBuilder
    public void empty(StringBuilder sb) throws InvalidInputException {
    	HelperUtil.isNull(sb);
        sb.delete(0, length(sb));
    }
    
    
    
    //Q1
    // Empty and add the new String to the StringBuilder
    public StringBuilder emptyAndAppend(StringBuilder sb, String str)  throws InvalidInputException{
    	HelperUtil.isNull(sb);
    	HelperUtil.isNull(str);
        empty(sb);//swami
        return sb.append(str);
    }
        
    
    public StringBuilder joinStringArrayWithDelimiter(StringBuilder sb, String delimiter, String arr[]) throws InvalidInputException{
    	HelperUtil.isNull(sb);
    	HelperUtil.isNull(delimiter);
        
        //return sb.append(String.join(delimiter, arr));//swami
        for (int i = 0; i < arr.length; i++) {
	    sb.append(arr[i]);
	    if (i < arr.length - 1) { 
		sb.append(delimiter);
	    }
	}
	
	return sb;
    }
    
    
    
    // Q2 -> 
    public StringBuilder joinStringArrayWithString(StringBuilder sb, String delimiter, String arr[]) throws InvalidInputException{
    	HelperUtil.isNull(sb);
    	HelperUtil.isNull(delimiter);
    	sb.append(delimiter);
    	joinStringArrayWithDelimiter(sb, delimiter, arr);
    	return sb;
    
    }
    
    
    //0  1  2    3     4    5 6
    //hi-I-am-raksha-priyan
    //Q3 -> 
    public  StringBuilder insertInBetweenWithDelimiter(StringBuilder sb, String delimiter, String insertString, int insertPos, int size) throws InvalidInputException {
        HelperUtil.isNull(sb);
        HelperUtil.isNull(delimiter);
        HelperUtil.validateBoundary(size, insertPos);
        
        if (insertPos == size - 1) {
            sb.append(delimiter);
            sb.append(insertString);//swami
        } else {
            int delimiterCount = 0;
            int currentIndex = 0;
            int pos = 0;
            int delimiterLength = delimiter.length();

            while (delimiterCount < insertPos - 1) {
                currentIndex = sb.indexOf(delimiter, pos);
                delimiterCount++;
                pos = currentIndex + delimiterLength;//swami
            }

            sb.insert(pos, insertString + delimiter);
        }

        return sb;
    }
    
    
    
    
    //Q4 ->
    public  StringBuilder deleteAtPosition(StringBuilder sb, int deletePos, String delimiter, int size) throws InvalidInputException {
        HelperUtil.isNull(sb);
        HelperUtil.isNull(delimiter);
        HelperUtil.validateBoundary(size, deletePos);
        
        if (deletePos == 0) {
            int endIndex = sb.indexOf(delimiter) + delimiter.length();//check logic
            sb.delete(0, endIndex);
            
        } else {
            int startIndex = 0;
            for (int i = 0; i < deletePos; i++) {
                startIndex = sb.indexOf(delimiter, startIndex);
                startIndex++;
            }
            
            int endIndex = sb.indexOf(delimiter, startIndex);
            if (endIndex == -1) {
               endIndex = sb.length();
            }
            sb.delete(startIndex - 1, endIndex);
            
        }
        return sb;
    }
    
    
    
    
    
    
    //Q5 ->
    public  StringBuilder replaceDelimiter(StringBuilder sb, String replace, String delimiter) throws InvalidInputException {
    	HelperUtil.isNull(sb);
    	HelperUtil.isNull(replace);
    	HelperUtil.isNull(delimiter);
        int index;
        
       while ((index = sb.indexOf(delimiter)) != -1) {
            sb.replace(index, index + delimiter.length(), replace);
        }

        return sb; 
    }
    
    //Q6 ->
    public StringBuilder reverse(StringBuilder sb) throws InvalidInputException{
    	HelperUtil.isNull(sb);
    	return sb.reverse();
    }
    
    
    //Q7 -> 
    public StringBuilder deleteAtRange(StringBuilder sb,  int start, int end) throws InvalidInputException{
    	HelperUtil.isNull(sb);
    	int length = length(sb);
    	HelperUtil.validateBoundary(length, start);
    	HelperUtil.validateBoundary(length, end);
    	HelperUtil.isStartLesserThanEnd(start, end);
    	return sb.delete(start, end);
    }
    
    //Q8 -> 
    public StringBuilder replaceAtRange(StringBuilder sb, String str, int start, int end, String replaceString) throws InvalidInputException{
    	HelperUtil.isNull(sb);
    	HelperUtil.isNull(str);
    	int length = length(sb);
    	HelperUtil.isNull(replaceString);
    	HelperUtil.validateBoundary(length, start);
    	HelperUtil.validateBoundary(length, end);
    	HelperUtil.isStartLesserThanEnd(start, end);
    	return sb.replace(start, end, replaceString);
    }
    
    
    //Q9 ->
    public int firstIndexOfDelimiter(StringBuilder sb, String delimiter) throws InvalidInputException{
    	HelperUtil.isNull(sb);
    	return sb.indexOf(delimiter);
    }
    
    
    
    
    //Q10 ->
    public int lastIndexOfDelimiter(StringBuilder sb, String delimiter) throws InvalidInputException{
    	HelperUtil.isNull(sb);
    	HelperUtil.isNull(delimiter);
    	return sb.lastIndexOf(delimiter);
    }
}





