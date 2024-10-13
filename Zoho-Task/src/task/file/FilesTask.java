package task.file;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Properties;

public class FilesTask {
	
	//Q1
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
	
	
	public void writePropertiesIntofile(Properties properties, String fileName) throws IOException {
		Path path = Paths.get(fileName);
		properties.store(Files.newBufferedWriter(path), null);
	}
	


	public void writePropertiesIntoFile(Properties properties, String dirPath, String fileName) throws IOException {
        Path dir = Paths.get(dirPath);
        if (!Files.exists(dir)) {
            Files.createDirectories(dir);
            System.out.println("Directory created: " + dirPath);
        }

        Path path = Paths.get(dirPath, fileName);
        
        properties.store(Files.newBufferedWriter(path), null);
        System.out.println("Properties written to file: " + path.toString());
    }
	
	public void loadPropertiesFromFile(Properties properties, String path) throws IOException {
        
		Path filePath = Paths.get(path);
		properties.load(Files.newBufferedReader(filePath));
		
    }


	public void loadPropertiesFromFile(Properties properties, String dirPath, String fileName) throws IOException {
        Path filePath = Paths.get(dirPath, fileName);
        
        if (Files.exists(filePath)) {
            properties.load(Files.newBufferedReader(filePath));
            System.out.println("Properties loaded from file: " + filePath.toString());
        } else {
            System.out.println("File not found: " + filePath.toString());
        }
    }
}
