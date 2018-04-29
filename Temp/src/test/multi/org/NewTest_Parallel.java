package test.multi.org;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import test.base.Excelread;

import test.utils.Utility;

public class NewTest_Parallel {
	//Property_base base = new Property_base();
	public WebDriver driver;
	  @Parameters("browser")

	  @BeforeClass
	  public void beforeClass(String browser) throws IOException {
		  if(browser.equalsIgnoreCase("firefox")){
			  System.setProperty("webdriver.gecko.driver", "/jars/geckodriver.exe");
			  driver=new FirefoxDriver();
			  
					 
		  }
		  else if (browser.equalsIgnoreCase("chrome")){
		
			  
			
			System.setProperty("webdriver.chrome.driver", "/jars/chromedriver.exe");
			driver=new ChromeDriver();
		}
		  driver.get("https://www.google.co.in/?gfe_rd=cr&dcr=0&ei=rUSyWrfTFsOBz7sP1v264AU");
	  }
	  @Test
	  public void f() throws EncryptedDocumentException, InvalidFormatException, IOException {
		  
		  System.out.println(Excelread.ExcelData(0, 0));
		  driver.findElement(By.id("test")).click();
		  
		 driver.close();
	  }
		@AfterMethod
		public void tearDo(ITestResult result) throws IOException {
			if (ITestResult.FAILURE == result.getStatus()) {
		  Utility.captureScreenshot(driver, "Register");
		  
	  }
	  
		}

	}
