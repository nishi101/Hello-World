package net.naturesnap.apiclient.http.requests;

import net.naturesnap.apiclient.http.enums.Format;
import net.naturesnap.apiclient.http.enums.Type;

public class ImageUpload extends Request {
	public String file;
	public ImageUpload(){
		this.setEndpoint("imageUploader.php");
		this.setFormat(Format.CODE);
		this.setParams("filename","latitude","longitude");
		this.setType(Type.FILE);
		this.setResult(ImageUpload.class);
	}
}
