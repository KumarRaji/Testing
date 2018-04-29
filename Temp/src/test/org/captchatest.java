package test.org;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class captchatest {
  @Test
  public void f() throws InterruptedException {
	  System.setProperty("webdriver.gecko.driver", "/jars/geckodriver.exe");
	  WebDriver driver =new FirefoxDriver();
	  driver.get("https://grandeurstay.com/dummy-registration/");
	  driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		//Yellow bed select (or) bed selection
//		WebElement passelement = driver.findElement(By.xpath("//*[@id=\"floor1\"]/a[3]"));
//		Actions action1 = new Actions(driver);
//		action1.moveToElement(passelement).click().perform();
	  driver.findElement(By.className("btn")).click();	
	  driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
	  String parent = driver.getWindowHandle();

		// Perform the click operation that opens new window	// Switch to new window opened
		for(String winHandle : driver.getWindowHandles()){
		    driver.switchTo().window(winHandle);
		}
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		Thread.sleep(2000);
	  
	  driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		List<WebElement> dates = driver.findElements(By.xpath("//*[@id=\"floor1\"]//a"));
		int total_node = 15;
		for (int i = 0; i < total_node; i++) {
			String date = dates.get(i).getCssValue("background-color");
				if (date.equals("rgba(255, 186, 0, 0.50)")) {
				dates.get(i).click();
				break;
			}			
		}
	  

	  
  }
	  
  }
