package int221.project.Porject221.models;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Color {
	
	@Id
	private long colorId;
	private String colorName;
	private String colorCode;

	public long getColorId() {
		return colorId;
	}

	public void setColorId(long colorId) {
		this.colorId = colorId;
	}

	public String getColorName() {
		return colorName;
	}

	public void setColorName(String colorName) {
		this.colorName = colorName;
	}

	public String getColorCode() {
		return colorCode;
	}

	public void setColorCode(String colorCode) {
		this.colorCode = colorCode;
	}

}
