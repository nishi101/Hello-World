package net.naturesnap.apiclient.http.results;

public class PhotoItem extends Result {
	public String photo_id;
	public String description;
	public boolean success;
	public String name;
	public String image_name;
	public int views;
	public boolean priv;
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
	public String getPhoto_id() {
		return photo_id;
	}
	public boolean isSuccess() {
		return success;
	}
	public String getName() {
		return name;
	}
	public String getImage_name() {
		return image_name;
	}
	public int getViews() {
		return views;
	}
	public boolean isPriv() {
		return priv;
	}
}