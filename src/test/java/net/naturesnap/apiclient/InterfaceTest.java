package net.naturesnap.apiclient;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import net.naturesnap.apiclient.http.requests.Login;
import net.naturesnap.apiclient.http.requests.Register;

public class InterfaceTest {
	@Test
	public void successfulLogin() {
		assertEquals(Interface.apiRequest(new Login(), new String[]{"jane", "doe"}),"success");
	}
	@Test
	public void failedLogin() {
		assertEquals(Interface.apiRequest(new Login(), new String[]{"jane", "do"}),"error");
	}
	@Test
	public void failedRegisterLastName() {
		assertEquals(Interface.apiRequest(new Register(), new String[]{"John", "", "johndoe@gmail.com", "john", "doe"}),"invalid");
	}
	@Test
	public void failedRegisterFirstName() {
		assertEquals(Interface.apiRequest(new Register(), new String[]{"", "Doe", "johndoe@gmail.com", "john", "doe"}),"invalid");
	}
	@Test
	public void failedRegisterInvalidEmail() {
		assertEquals(Interface.apiRequest(new Register(), new String[]{"John", "Doe", "johndoe@gmail", "john", "doe"}),"invalid");
	}
	@Test
	public void failedRegisterEmail() {
		assertEquals(Interface.apiRequest(new Register(), new String[]{"John", "Doe", "", "john", "doe"}),"invalid");
	}
	@Test
	public void failedRegisterUsername() {
		assertEquals(Interface.apiRequest(new Register(), new String[]{"John", "Doe", "johndoe@gmail.com", "", "doe"}),"invalid");
	}
	@Test
	public void failedRegisterPassword() {
		assertEquals(Interface.apiRequest(new Register(), new String[]{"John", "Doe", "johndoe@gmail.com", "john", ""}),"invalid");
	}
	@Test
	public void failedRegisterExists() {
		assertEquals(Interface.apiRequest(new Register(), new String[]{"John", "Doe", "johndoe@gmail.com", "john", "doe"}),"exists");
	}
}
