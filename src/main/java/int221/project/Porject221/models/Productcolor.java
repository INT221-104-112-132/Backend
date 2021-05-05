package int221.project.Porject221.models;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Productcolor {
	
	@Id
	private long productId;
	private long colorId;

	public long getProductId() {
		return productId;
	}

	public void setProductId(long productId) {
		this.productId = productId;
	}

	public long getColorId() {
		return colorId;
	}

	public void setColorId(long colorId) {
		this.colorId = colorId;
	}

}
