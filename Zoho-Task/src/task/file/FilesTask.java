package task.file;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Properties;

import task.exception.InvalidInputException;
import task.util.HelperUtil;

public class FilesTask {
	
	private final String currentDirectory = System.getProperty("user.dir");
	//Q1
	public Path writeInFile(String fileName, Iterable<? extends CharSequence> lines) throws IOException, InvalidInputException {
		String filePath = currentDirectory;
		return writeInFile(filePath,fileName, lines);
	}
	
	
	public Path writeInFile(String filePath, String fileName, Iterable<? extends CharSequence> lines) throws IOException, InvalidInputException {
		HelperUtil.isNull(filePath);
		HelperUtil.validateDirectory(filePath);
		Path path = Paths.get(filePath, fileName);
		return path;
	}
	
	
	public Properties getProperties() {
		return new Properties();
	}
	
	
	public void addProperty(Properties properties, String key, String value) {
        properties.setProperty(key, value);
    }
	
	
	public void writePropertiesIntofile(Properties properties, String fileName) throws IOException, InvalidInputException {
		String filePath = currentDirectory;
		writePropertiesIntoFile(properties, filePath, fileName);
	}
	


	public void writePropertiesIntoFile(Properties properties, String filePath, String fileName) throws IOException, InvalidInputException {
		HelperUtil.isNull(filePath);
        HelperUtil.validateDirectory(filePath);
        Path path = Paths.get(filePath, fileName);
        properties.store(Files.newBufferedWriter(path), null);
    }
	
	public void loadPropertiesFromFile(Properties properties, String fileName) throws IOException, InvalidInputException {
		String filePath = currentDirectory;
		loadPropertiesFromFile(properties, filePath, fileName);
    }

	public void loadPropertiesFromFile(Properties properties, String filePath, String fileName) throws IOException, InvalidInputException {
		HelperUtil.isNull(filePath);
		HelperUtil.validateDirectory(filePath);
        Path path = Paths.get(filePath, fileName);
        properties.load(Files.newBufferedReader(path));	
    }
}
