package test.org;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import test.base.Excelread;
import test.pom.DataCollect;

public class Login_test {
	WebDriver driver;
	
	@BeforeMethod
	public void setUp() {
		System.setProperty("webdriver.gecko.driver", "/jars/geckodriver.exe");
		  driver =new FirefoxDriver();
		  driver.get("https://test.grandeurstay.com/login");
		  driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		  
	}
	@Test(priority=1)
  public void f() throws EncryptedDocumentException, InvalidFormatException, IOException, InterruptedException {
		DataCollect data = new DataCollect(driver);
		data.typefirstname(Excelread.ExcelData(0, 0));
		data.typepassword(Excelread.ExcelData(0, 0));
	  driver.findElement(By.xpath("//button[@type='submit']")).click();
	   
  }
	@Test(priority=2)
	  public void validVerify() {
		  driver.findElement(By.xpath("//button[@type='submit']")).click();	
          Boolean b  = driver.findElement(By.id("UserUsername")).isDisplayed();
		  System.out.println(b);
		  
	  }
  @Test(priority=3)
  public void login() throws InterruptedException {

	  driver.findElement(By.id("UserUsername")).sendKeys("bb");
	  driver.findElement(By.id("UserPassword")).sendKeys("bb");
	  driver.findElement(By.xpath("//button[@type='submit']")).click();	
	  driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	  Assert.assertEquals(driver.findElement(By.xpath("//*[@id=\"UserLoginForm\"]/div[2]/div/div/div")).getText(), "Invalid Username or password");
	  
  }
	  
	/*  String actual = driver.findElement(By.partialLinkText("Invalid Username or password")).getText();
		String excepted = "Invalid Username or password";
		if (actual.equals(excepted)) {
			System.out.println("Success");
		} else {
			System.out.println("Failure");
		}
	  
  }*/
  
  @AfterMethod
	public void closetest() {
		driver.close();
	}
}
