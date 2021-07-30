package dev.beale.steps;

import static org.junit.Assert.assertEquals;

import org.openqa.selenium.WebDriver;

import dev.beale.pages.HomePage;
import dev.beale.runners.WebRunner;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class WebTestStepImpl {

	public static HomePage homepage = WebRunner.homePage;
	public static WebDriver driver = WebRunner.driver;

	@Given("The User is on the Login Page")
	public void the_user_is_on_the_login_page() {
		driver.get("C:/Users/Presentfob/Documents/Visual-Studio-Code/WebPages/TRMS/Login.html");
	}

	@When("The User enters username as {string} and types {string} for password")
	public void the_user_enters_username_as_and_types_for_password(String string, String string2) {
		homepage.usernameInput.sendKeys(string);
		homepage.passwordInput.sendKeys(string2);
	}

	@When("The User clicks the Login button")
	public void the_user_clicks_the_login_button() {
		homepage.logIn.click();
	}

	@Then("The User should be on the Login")
	public void the_user_should_be_on_the_login() {
		assertEquals("Login", driver.getTitle());
	}

	@Given("^The User is on the Home Page$")
	public void the_User_is_on_the_Home_Page() {
		driver.get("C:/Users/Presentfob/Documents/Visual-Studio-Code/WebPages/TRMS/HomePage.html");
	}

	@When("^The User clicks Reimbursements$")
	public void the_User_clicks_Reimbursements() {
		homepage.reimbursements.click();
	}

	@Then("^The User should be on the Reimbursements Home Page$")
	public void the_User_should_be_on_the_Reimbursements_Home_Page() {
		assertEquals("Reimbursements", driver.getTitle());
	}

	@When("^The User clicks Account Details$")
	public void the_User_clicks_Account_Details() {
		homepage.accountDetails.click();
	}

	@Then("^The User should be on the Account Details Page$")
	public void the_User_should_be_on_the_Account_Details_Page() {
		assertEquals("Account Details", driver.getTitle());
	}

	@When("^The User clicks Contact$")
	public void the_User_clicks_Contact() {
		homepage.contact.click();
	}

	@Then("^The User should be on the Contact Page$")
	public void the_User_should_be_on_the_Contact_Page() {
		assertEquals("Requests", driver.getTitle());
	}

	@When("^The User clicks Log Out$")
	public void the_User_clicks_Log_Out() {
		homepage.logOut.click();
	}

	@Then("^The User should be on the Login Page$")
	public void the_User_should_be_on_the_Login_Page() {
		assertEquals("Login", driver.getTitle());
	}
}