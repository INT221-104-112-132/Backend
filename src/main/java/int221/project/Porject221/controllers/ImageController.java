package int221.project.Porject221.controllers;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;

import int221.project.Porject221.models.Image;
import int221.project.Porject221.storageservices.StorageService;

@RestController
@RequestMapping("/image")
public class ImageController {
	
	final StorageService storageService;
	
    @Autowired
    public ImageController(StorageService storageService) {
        this.storageService = storageService;
    }
    
    @GetMapping("/allImage")
    public List<Image> getListFile() throws IOException {
        return storageService.loadAll().map(path -> {
            String imageName = path.getFileName().toString();
            String imageUrl = MvcUriComponentsBuilder.fromMethodName(ImageController.class,"getFile",path.getFileName().toString()).build().toString();
            return new Image(imageName,imageUrl);
        }).collect(Collectors.toList());
    }
    
    @GetMapping(value = "/{imageName:.+}",produces = MediaType.IMAGE_PNG_VALUE)
    public Resource getFile(@PathVariable String imageName) throws IOException, URISyntaxException {
        return storageService.loadAsResource(imageName);
    }
    
    @PostMapping("/uploadImage")
    public ResponseEntity<String> uploadFile(@RequestParam("file")MultipartFile file){
        try {
            storageService.store(file);
            return ResponseEntity.status(HttpStatus.OK).body("Uploaded: "+file.getOriginalFilename());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body("UpFail to upload: "+e.getMessage());
        }
    }
    
}
