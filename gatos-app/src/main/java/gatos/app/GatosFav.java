package gatos.app;

public class GatosFav {
	
	private String id;
	private String imageId;
	private String apiKey = "079c3bda-2f4a-4b53-97d2-be917b5c1f66";
	private Imagex image;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getImageId() {
		return imageId;
	}
	public void setImageId(String imageId) {
		this.imageId = imageId;
	}
	public String getApiKey() {
		return apiKey;
	}
	public void setApiKey(String apiKey) {
		this.apiKey = apiKey;
	}
	public Imagex getImage() {
		return image;
	}
	public void setImage(Imagex image) {
		this.image = image;
	}
	
}
