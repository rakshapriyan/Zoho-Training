package task.util;

import task.exception.InvalidInputException;
import task.constant.ErrorConstant;


public class HelperUtil{
	  
    
    // Checking whether a string is null or empty
    public static void isNull(Object obj) throws InvalidInputException {
        if (obj == null) {
            throw new InvalidInputException(ErrorConstant.NULL_STRING_EXCEPTION);
        }
    }
    
    
    // Check the given number is in range
    public static void validateBoundary(int length, int number) throws InvalidInputException {
        if (number < 0 || number > length) {
            throw new InvalidInputException(ErrorConstant.OUT_OF_LIMITS_EXCEPTION);
        }
    }

    
    
}
