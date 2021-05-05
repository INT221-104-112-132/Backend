package int221.project.Porject221.models;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Product {
	
	@Id
	private long productId;
	private String productName;
	private String productDescription;
	private long price;
	private java.sql.Timestamp manufactureDate;
	private long brandBrandId;

	public long getProductId() {
		return productId;
	}

	public void setProductId(long productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductDescription() {
		return productDescription;
	}

	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}

	public long getPrice() {
		return price;
	}

	public void setPrice(long price) {
		this.price = price;
	}

	public java.sql.Timestamp getManufactureDate() {
		return manufactureDate;
	}

	public void setManufactureDate(java.sql.Timestamp manufactureDate) {
		this.manufactureDate = manufactureDate;
	}

	public long getBrandBrandId() {
		return brandBrandId;
	}

	public void setBrandBrandId(long brandBrandId) {
		this.brandBrandId = brandBrandId;
	}

}
