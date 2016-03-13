package net.naturesnap.apiclient.http;

import net.naturesnap.apiclient.http.enums.Format;
import net.naturesnap.apiclient.http.enums.Type;

public class LatestPhotos extends Request {
	public LatestPhotos(){
		this.setEndpoint("latest.php");
		this.setFormat(Format.JSON);
		this.setParams("limit");
		this.setType(Type.GET);
		this.setResult(null);
	}
}
