package net.naturesnap.apiclient.http.requests;

import net.naturesnap.apiclient.http.enums.Format;
import net.naturesnap.apiclient.http.enums.Type;

public class Request {
	public String endpoint;
	public String[] params;
	public Type type;
	public Format format;
	public Class<?> Result;
	public Class<?> getResult() {
		return Result;
	}
	public void setResult(Class<?> result) {
		Result = result;
	}
	public String getEndpoint() {
		return endpoint;
	}
	public void setEndpoint(String endpoint) {
		this.endpoint = endpoint;
	}
	public String[] getParams() {
		return params;
	}
	public void setParams(String... params) {
		this.params = params;
	}
	public Type getType() {
		return type;
	}
	public void setType(Type type) {
		this.type = type;
	}
	public Format getFormat() {
		return format;
	}
	public void setFormat(Format format) {
		this.format = format;
	}
}
