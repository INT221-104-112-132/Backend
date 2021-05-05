package int221.project.Porject221.storageservices;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Objects;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.util.FileSystemUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

@Service
public class FileStorageService implements StorageService {
	
	final Path rootLocation;
	
	@Autowired
	private FileStorageService(StorageProperties properties) {
		this.rootLocation = Paths.get(properties.getLocation());
	}
	
	@Override
	public void init() {
		 try {
	            Files.createDirectories(rootLocation);
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
		
	}

	@Override
	public String store(MultipartFile file) throws Exception {
		String fileName = StringUtils.cleanPath(Objects.requireNonNull(file.getOriginalFilename()));
        int fileExtensionPosition = fileName.lastIndexOf(".");
        if(fileExtensionPosition > 0){
            fileName = file.getOriginalFilename().substring(0,fileExtensionPosition);
        }
        return store(file);
	}

	@Override
	public Stream<Path> loadAll() throws IOException {
		Stream<Path> stream = Files.list(rootLocation);
		return stream;
	}

	@Override
	public Path load(String fileName) throws IOException {
		return rootLocation.resolve(fileName);
	}

	@Override
	public Resource loadAsResource(String fileName) throws IOException {
		try {
            Resource resource = new UrlResource(load(fileName).toUri());
            if(resource.exists()) {
                return resource;
            } else {
                throw new FileNotFoundException("File: " + fileName + "not found");
            }
        } catch (MalformedURLException ex) {
            throw new FileNotFoundException("File: " + fileName + "not found");
        }
	}

	@Override
	public void deleteAll() throws IOException {
		FileSystemUtils.deleteRecursively(rootLocation.toFile());
	}

	@Override
	public void delete(String fileName) throws IOException {
		load(fileName).toFile().delete();
	}

}
