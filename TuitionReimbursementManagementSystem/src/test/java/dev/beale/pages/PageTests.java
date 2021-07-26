package dev.beale.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class PageTests {

	public static void main(String[] args) {

		String driverPath = "C:/Users/Presentfob/Documents/chromedriver_win32/chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", driverPath);

		WebDriver driver = new ChromeDriver();
		HomePage homePage = new HomePage(driver);

		String url = "C:/Users/Presentfob/Documents/Visual-Studio-Code/WebPages/TRMS/HomePage.html";
		driver.get(url);

//			wikiMain.english.click();
		homePage.clickReimbursements();

		driver.get(url);
		homePage.clickAccountDetails();

		driver.get(url);
		homePage.clickContact();

		driver.get(url);
		homePage.clickLogOut();
		

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		driver.quit();
	}
}
