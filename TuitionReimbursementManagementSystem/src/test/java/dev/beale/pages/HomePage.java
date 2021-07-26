package dev.beale.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

	public WebDriver driver;

	@FindBy(xpath = "/html/body/nav/div/ul/li[2]/a")
	public WebElement reimbursements;

	@FindBy(xpath = "//*[@id=\"accDeets\"]")
	public WebElement accountDetails;

	@FindBy(xpath = "//*[@id=\"contact\"]")
	public WebElement contact;

	@FindBy(xpath = "/html/body/nav/div/ul/li[5]/a")
	public WebElement logOut;

	@FindBy(xpath = "//*[@id=\"loginPage\"]/button")
	public WebElement logIn;

	@FindBy(id = "username")
	public WebElement usernameInput;

	@FindBy(id = "password")
	public WebElement passwordInput;

	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void clickReimbursements() {
		reimbursements.click();
	}

	public void clickAccountDetails() {
		accountDetails.click();
	}

	public void clickContact() {
		contact.click();
	}

	public void clickLogOut() {
		logOut.click();
	}

	public void clickLogIn() {
		logIn.click();
	}

}
