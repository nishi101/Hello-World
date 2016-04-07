package net.naturesnap.apiclient.http.results;

import java.util.List;


public class PhotoData extends Result {
	private List<PhotoItem> data;

	public List<PhotoItem> getData() {
		return data;
	}

	public void setData(List<PhotoItem> data) {
		this.data = data;
	}
	
}
