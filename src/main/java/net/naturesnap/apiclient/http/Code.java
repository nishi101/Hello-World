package net.naturesnap.apiclient.http;

public class Code extends Result {
	private String response;
	public Code(String res){
		this.response = res;
	}
	public String getResponse() {
		return response;
	}
	public void setResponse(String response) {
		this.response = response;
	}
}
