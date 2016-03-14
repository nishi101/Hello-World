package net.naturesnap.apiclient.http.requests;

import net.naturesnap.apiclient.http.enums.Format;
import net.naturesnap.apiclient.http.enums.Type;
import net.naturesnap.apiclient.http.results.Code;

public class ImageDelete extends Request {
	public ImageDelete(){
		this.setEndpoint("deletePhoto.php");
		this.setFormat(Format.CODE);
		this.setParams("photo_id", "username", "user_id");
		this.setType(Type.POST);
		this.setResult(Code.class);
	}
}
