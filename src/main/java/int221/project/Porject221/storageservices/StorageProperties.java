package int221.project.Porject221.storageservices;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix ="smartphonedb.storage")
public class StorageProperties {

    private String location;

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
