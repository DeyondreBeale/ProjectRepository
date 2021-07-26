package dev.beale.steps;

import static org.junit.Assert.assertEquals;

import org.openqa.selenium.WebDriver;

import dev.beale.pages.HomePage;
import dev.beale.runners.LoginRunner;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginTestStepImpl {

	public static HomePage homepage = LoginRunner.homePage;
	public static WebDriver driver = LoginRunner.driver;

	@Given("The Guest is on the Login Page")
	public void the_guest_is_on_the_login_page() {
		driver.get("C:/Users/Presentfob/Documents/Visual-Studio-Code/WebPages/TRMS/Login.html");
	}

	@When("The User types in {string} and {string}")
	public void the_user_types_in_and(String string, String string2) {
		homepage.usernameInput.sendKeys(string);
		homepage.passwordInput.sendKeys(string2);
	}

	@When("Presses the Login button")
	public void presses_the_login_button() {
		homepage.logIn.click();
	}

	@Then("The Guest should be at Login page")
	public void the_guest_should_be_at_login_page() {
		assertEquals("Login", driver.getTitle());
	}
}
