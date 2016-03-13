package net.naturesnap.apiclient.http.requests;

import net.naturesnap.apiclient.http.enums.Format;
import net.naturesnap.apiclient.http.enums.Type;

public class ImageUpdate extends Request {
	public ImageUpdate(){
		this.setEndpoint("updateImage.php");
		this.setFormat(Format.CODE);
		this.setParams("photo_id", "filename", "username", "user_id");
		this.setType(Type.POST);
		this.setResult(null);
	}
}
