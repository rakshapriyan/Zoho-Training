package task.util;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import task.constant.ErrorConstant;
import task.exception.InvalidInputException;

public class HelperUtil {

    // Checking whether a string is null or empty
    public static void isNull(Object obj) throws InvalidInputException {
        if (obj == null) {
            throw new InvalidInputException(ErrorConstant.NULL_VALUE_EXCEPTION);
        }
    }

    // Check the given number is in range
    public static void validateBoundary(int length, int number) throws InvalidInputException {
        if (number < 0 || number > length) {
            throw new InvalidInputException(String.format(ErrorConstant.OUT_OF_LIMITS_EXCEPTION, number, length));
        }
    }
    
    public static void isStartLesserThanEnd(int start, int end) throws InvalidInputException {
    	if(start > end){
    		throw new InvalidInputException(String.format(ErrorConstant.SMALLER_NUMBER_EXCEPTION, start, end));
    	}
    }
    
    
    public static void validateDirectory(String dir) throws IOException {
    	Path path = Paths.get(dir);
		if (Files.notExists(path) || !Files.isDirectory(path)) {
            throw new IOException(ErrorConstant.DIRECTORY_NOT_FOUND + dir);
        }
	}
}

