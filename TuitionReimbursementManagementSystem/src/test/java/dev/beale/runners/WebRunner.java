package dev.beale.runners;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import dev.beale.pages.HomePage;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/WebTest.feature", glue = { "dev.beale.steps", "WebTestStepImpl" })
public class WebRunner {

	public static WebDriver driver;
	public static HomePage homePage;

	@BeforeClass
	public static void setUp() {
		String path = "C:/Users/Presentfob/Documents/chromedriver_win32/chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", path);

		driver = new ChromeDriver();
		homePage = new HomePage(driver);
	}

	@AfterClass
	public static void tearDown() {
		driver.quit();
	}
}
