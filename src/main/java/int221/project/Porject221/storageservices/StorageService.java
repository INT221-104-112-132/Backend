package int221.project.Porject221.storageservices;

import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;
import java.nio.file.Path;
import java.util.stream.Stream;

@Service
public interface StorageService {
	
	void init();

	String store(MultipartFile file) throws Exception;

	Stream<Path> loadAll() throws IOException;

	Path load(String fileName) throws IOException;

	Resource loadAsResource(String fileName) throws IOException;

	void deleteAll() throws IOException;

	void delete(String fileName) throws IOException;
}

