package AutoRun;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;

public class testngRunPratice {
	WebDriver driver;

	@Parameters("browser")
	@BeforeTest
	public void lunchbrowser(String browser) {
		if(browser.equalsIgnoreCase("chrome")) {
			driver=new ChromeDriver();
			WebDriverManager.chromedriver().setup();
		}else if(browser.equalsIgnoreCase("firefox")) {
			driver=new FirefoxDriver();
			WebDriverManager.firefoxdriver().setup();
		}
		else if(browser.equalsIgnoreCase("edge")) {
			driver=new EdgeDriver();
			WebDriverManager.edgedriver().setup();
		}else {
			System.out.println("There is no proper browser mentioned");
		}

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
