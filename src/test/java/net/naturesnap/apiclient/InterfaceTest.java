package net.naturesnap.apiclient;

import org.junit.Test;
import net.naturesnap.apiclient.http.requests.Login;

public class InterfaceTest {

	@Test
	public void successfulLogin() {
		assert(Interface.apiRequest(new Login(), new String[]{"jane", "doe"}).equals("success"));
	}
	@Test
	public void failedLogin() {
		assert(Interface.apiRequest(new Login(), new String[]{"jane", "do"}).equals("error"));
	}

}
