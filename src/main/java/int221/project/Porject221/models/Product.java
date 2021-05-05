package int221.project.Porject221.models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
public class Product {

	@Id
	private long productId;
	private String productName;
	private String productDescription;
	private long price;
	private java.sql.Timestamp manufactureDate;
	private String productImage;
	private long brandBrandId;

	@ManyToOne
	@JoinColumn(name = "brandId", insertable = false, updatable = false)
	Brand brand;

	@ManyToMany
	@JoinTable(name = "productcolor", joinColumns = @JoinColumn(name = "productId"), inverseJoinColumns = @JoinColumn(name = "colorId"))
	private List<Color> colorList;

	public Brand getBrand() {
		return brand;
	}

	public void setBrand(Brand brand) {
		this.brand = brand;
	}

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

	public String getProductImage() {
		return productImage;
	}

	public void setProductImage(String productImage) {
		this.productImage = productImage;
	}

	public List<Color> getColorList() {
		return colorList;
	}

	public void setColorList(List<Color> colorList) {
		this.colorList = colorList;
	}
}
