package dev.beale.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebpageTest {

	public static void main(String[] args) {

		String driverPath = "C:/Users/Presentfob/Documents/chromedriver_win32/chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", driverPath);

		WebDriver driver = new ChromeDriver();

		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

		driver.get("http://www.google.com/");

		WebElement searchbar = driver.findElement(By.name("q"));
		searchbar.sendKeys("Vin Diesel Family memes");
//		searchbar.sendKeys(Keys.ENTER);
//		searchbar.sendKeys(Keys.ARROW_DOWN, Keys.ENTER);

		WebElement searchBtn = driver.findElement(By.name("btnK"));
		searchBtn.click();

//		driver.navigate().refresh(); //Nice.

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		/*
		 * Selenium Waits:
		 * 
		 * 3 Main Types:
		 * 
		 * - Implicit Waits - Will wait up to a given amount of time before throwing an
		 * exception. - Explicit Waits - Will wait until a certain condition occurs
		 * before proceeding with execution - Fluent Waits - Will wait a maximum amount
		 * of time for a condition to occur and will check if the condition appears at
		 * regular intervals.
		 */

		driver.quit(); // Closes all browsers managed by Selenium and shuts down the WebDriver.
//		driver.close(); //Closes the current browser
	}
}
