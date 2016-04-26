package net.naturesnap.apiclient;

import static org.junit.Assert.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import net.naturesnap.apiclient.http.results.PhotoItem;
import net.naturesnap.apiclient.http.results.UserResponse;
import org.junit.FixMethodOrder;
import org.junit.Test;
import net.naturesnap.apiclient.http.requests.Login;
import net.naturesnap.apiclient.http.requests.Photo;
import net.naturesnap.apiclient.http.requests.Register;
import net.naturesnap.apiclient.http.results.PhotoData;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class InterfaceTest {
	@Test
	public void ysuccessfulLogin() {
		UserResponse ur = (UserResponse) Interface.request(new Login(), new String[]{"jane", "doe"});
		assertEquals(ur.getSuccess(),true);
	}
	@Test
	public void failedLogin() {
		UserResponse ur = (UserResponse) Interface.request(new Login(), new String[]{"jane", "do"});
		assertEquals(ur.getSuccess(),false);
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
	@Test
	public void ztestPhotoFail() {
		PhotoItem pd = (PhotoItem) Interface.request(new Photo(), "7");
		assertEquals(pd.isSuccess(), false);
		
	}
	@Test
	public void ztestPhotoExists() {
		PhotoItem pd = (PhotoItem) Interface.request(new Photo(), "9");
		assertEquals(pd.isSuccess(), true);
	}
}
