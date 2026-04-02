package SeleniumPratice;

import java.io.File;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;



public class OpenBroser {

	public static void main(String[] args) {
		String timestamp = new java.text.SimpleDateFormat("yyyyMMdd_HHmmss").format(new java.util.Date());

		WebDriverManager.chromedriver().setup();
		WebDriver driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(20));
		driver.get("https://practicetestautomation.com/");
		driver.getTitle();
		TakesScreenshot sc= (TakesScreenshot)driver;
		File f1= sc.getScreenshotAs(OutputType.FILE);
		File f2 = new File(System.getProperty("user.dir") + "//Screenshot//Raja_sc_" + timestamp + ".png");
		File dir = new File(System.getProperty("user.dir") + "//Screenshot");
		if (dir.exists()) {
		    File[] files = dir.listFiles();
		    if (files != null) {
		        for (File file : files) {
		            file.delete();
		        }
		    }
		} else {
		    dir.mkdirs();
		}

		try {
		org.apache.commons.io.FileUtils.copyFile(f1,f2);
		}catch(Exception e){
			
		}
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
//		wait.until(ExpectedConditions.elementToBeClickable(By.tagName("a")));
		List<WebElement> links= driver.findElements(By.tagName("a"));
		System.out.println(links.size());
	try {
		for(int i=0;i<links.size();i++) {
			wait.until(ExpectedConditions.elementToBeClickable(By.tagName("a")));
			links.get(i).click();
		}
	}catch(Exception e) {
		
	}
	finally {
		driver.quit();
	}

	}

}
