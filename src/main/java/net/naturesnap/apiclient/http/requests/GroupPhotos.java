package net.naturesnap.apiclient.http.requests;

import net.naturesnap.apiclient.http.enums.Format;
import net.naturesnap.apiclient.http.enums.Type;
import net.naturesnap.apiclient.http.results.PhotoData;

public class GroupPhotos  extends Request {
	public GroupPhotos(){
		this.setEndpoint("photo.php");
		this.setFormat(Format.JSON);
		this.setParams("group_id");
		this.setType(Type.GET);
		this.setResult(PhotoData.class);
	}
}
