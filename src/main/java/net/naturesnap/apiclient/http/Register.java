package net.naturesnap.apiclient.http;

import net.naturesnap.apiclient.http.enums.Format;
import net.naturesnap.apiclient.http.enums.Type;

public class Register extends Request {
	public Register(){
		this.setEndpoint("register.php");
		this.setFormat(Format.CODE);
		this.setParams("name", "last_name", "email", "username", "password");
		this.setType(Type.POST);
		this.setResult(null);
	}
}
