package net.naturesnap.apiclient.http.results;

public class PhotoItem extends Result {
	private String photo_id;
	private String description;
	private String name;
	private String image_name;
	public String getPhotoId() {
		return photo_id;
	}
	public String getDescription() {
		return description;
	}
	public String getAccountName() {
		return name;
	}
	public String getImagePath() {
		return image_name;
	}
	
}
