package task.file;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
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
	
	
	public void writePropertiesIntofile(Properties properties, String fileName) throws IOException {
		Path path = Paths.get(fileName);
		properties.store(Files.newBufferedWriter(path), null);
	}
	
	
	public void loadPropertiesFromFile(Properties properties, String path) throws IOException {
        
		Path filePath = Paths.get(path);
		properties.load(Files.newBufferedReader(filePath));
		
    }
	
	
	

}
