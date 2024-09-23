package task.file;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class FilesTask {
	
	
	public Path writeInFile(String fileName, Iterable<? extends CharSequence> lines) throws IOException {
		Path path = Paths.get(fileName);
		Files.write(path, lines);
		return path;
	}
	
	
	
	public Path writeInFile(String filePath, String fileName, Iterable<? extends CharSequence> lines) throws IOException {
		Path dir = Paths.get(filePath);
		if (Files.notExists(dir)) {
            Files.createDirectories(dir);
		}
		Path path = Paths.get(filePath, fileName);
		Files.write(path, lines);
		return path;
	}
	
	
	public Properties getProperties() {
		return new Properties();
	}
	
	
	public void addProperty(Properties properties, String key, String value) {
        properties.setProperty(key, value);
    }
	
	
	public List<String> convertPropertiesToList(Properties properties, String delimiter) {
        List<String> lines = new ArrayList<>();
        properties.forEach((key, value) -> lines.add(key + delimiter + value));
        return lines;
    }
	
	public void writePropertiesIntofile(Properties properties, String delimiter, String filePath) throws IOException {
		List<String> lines = convertPropertiesToList(properties, delimiter);
		writeInFile(filePath, lines);
		
	}
	
	
	public void loadFromFile(Properties properties, String fileName, String delimiter) throws IOException {
        Path path = Paths.get(fileName);

        List<String> lines = Files.readAllLines(path);

        for (String line : lines) {
            
            String[] keyValue = line.split(delimiter, 2);
            if (keyValue.length == 2) {
                properties.setProperty(keyValue[0], keyValue[1]); 
            }
        }
    }
	
	
	

}
