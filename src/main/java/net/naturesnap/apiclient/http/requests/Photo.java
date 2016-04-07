package net.naturesnap.apiclient.http.requests;

import net.naturesnap.apiclient.http.enums.Format;
import net.naturesnap.apiclient.http.enums.Type;
import net.naturesnap.apiclient.http.results.PhotoData;

public class Photo extends Request {
	public Photo(){
		this.setEndpoint("photo.php");
		this.setFormat(Format.JSON);
		this.setParams("photo_id");
		this.setType(Type.GET);
		this.setResult(PhotoData.class);
	}
}
