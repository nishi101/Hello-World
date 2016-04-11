package net.naturesnap.apiclient.http.results;

import java.util.List;


public class PhotoData extends Result {
	private List<PhotoItem> data;
	private boolean success;
	public List<PhotoItem> getData() {
		return data;
	}

	public void setData(List<PhotoItem> data) {
		this.data = data;
	}

	public boolean isSuccess() {
		return success;
	}
	
}
