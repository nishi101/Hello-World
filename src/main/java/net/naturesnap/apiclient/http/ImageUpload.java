package net.naturesnap.apiclient.http;

import net.naturesnap.apiclient.http.enums.Format;
import net.naturesnap.apiclient.http.enums.Type;

public class ImageUpload extends Request {
	public ImageUpload(){
		this.setEndpoint("imageUploader.php");
		this.setFormat(Format.CODE);
		this.setParams("filename", "description");
		this.setType(Type.FILE);
		this.setResult(null);
	}
}
