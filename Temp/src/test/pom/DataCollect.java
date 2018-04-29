package test.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class DataCollect {
	WebDriver driver;
	By username1 = By.id("UserUsername");
	By password1 = By.id("UserPassword");
	
	public DataCollect (WebDriver driver) {
		this.driver = driver;
	}

	public void typefirstname(String setusername1) {
		driver.findElement(username1).sendKeys(setusername1);
	}
	public void typepassword(String setpassword1) {
		driver.findElement(password1).sendKeys(setpassword1);
	}

	
	
}