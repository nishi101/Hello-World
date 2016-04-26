package net.naturesnap.apiclient.http.requests;

import net.naturesnap.apiclient.http.enums.Format;
import net.naturesnap.apiclient.http.enums.Type;
import net.naturesnap.apiclient.http.results.UserResponse;

public class Login extends Request {
	public Login(){
		this.setEndpoint("login.php");
		this.setFormat(Format.JSON);
		this.setParams("username", "password");
		this.setType(Type.POST);
		this.setResult(UserResponse.class);
	}
}
