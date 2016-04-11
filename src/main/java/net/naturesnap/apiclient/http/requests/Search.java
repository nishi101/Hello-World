package net.naturesnap.apiclient.http.requests;

import net.naturesnap.apiclient.http.enums.Format;
import net.naturesnap.apiclient.http.enums.Type;
import net.naturesnap.apiclient.http.results.PhotoData;

public class Search extends Request {
	public Search(){
		this.setEndpoint("searchPhoto.php");
		this.setFormat(Format.JSON);
		this.setParams("search");
		this.setType(Type.GET);
		this.setResult(PhotoData.class);
	}
}
