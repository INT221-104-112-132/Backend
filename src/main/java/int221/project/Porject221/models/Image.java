package int221.project.Porject221.models;

public class Image {
	private String imageName;
	private String imageUrl;
	
	public Image(String imageName, String imageUrl) {
		this.imageName = imageName;
		this.imageUrl = imageUrl;
	}
	public String getImageName() {
		return imageName;
	}
	public void setImageName(String imageName) {
		this.imageName = imageName;
	}
	public String getImageUrl() {
		return imageUrl;
	}
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
	
}
