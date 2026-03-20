package AutoRun;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class testngRunPratice {
	WebDriver driver = new ChromeDriver();

	@BeforeTest
	public void lunchbrowser() {
		WebDriverManager.chromedriver().setup();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

	}

	@Test
	public void openWebsite() {
		driver.get("https://practicetestautomation.com/");
		driver.getTitle();
	}

	@AfterTest
	public void tearDown() {
		driver.quit();
	}

}
