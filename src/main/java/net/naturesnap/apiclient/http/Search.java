package net.naturesnap.apiclient.http;

import net.naturesnap.apiclient.http.enums.Format;
import net.naturesnap.apiclient.http.enums.Type;

public class Search extends Request {
	public Search(){
		this.setEndpoint("searchPhoto.php");
		this.setFormat(Format.JSON);
		this.setParams("search");
		this.setType(Type.GET);
		this.setResult(null);
	}
}
