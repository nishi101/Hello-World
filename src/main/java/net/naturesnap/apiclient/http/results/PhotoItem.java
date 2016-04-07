package net.naturesnap.apiclient.http.results;

public class PhotoItem extends Result {
	public String photo_id;
	public String description;
	public String name;
	public String image_name;
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
