package test.org;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import test.pom.DataCollect;

public class RacTest {
	 WebDriver driver;
		DataCollect data = new DataCollect(driver);
		@BeforeMethod
		public void setUp() {
			System.setProperty("webdriver.gecko.driver", "/jars/geckodriver.exe");
			  driver =new FirefoxDriver();
			  driver.get("https://test.grandeurstay.com/login");
			  driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
			  
		}
		
		  @Test(priority=1)
		  public void alertCancel() throws InterruptedException {

			  driver.findElement(By.id("UserUsername")).sendKeys("khuze");
			  driver.findElement(By.id("UserPassword")).sendKeys("siam123");
			  driver.findElement(By.xpath("//button[@type='submit']")).click();
			  driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
			  //driver.findElement(By.xpath("//form[@action='/branches/manager_login/1']")).click();
			  //grandeurstay click		  
			  driver.findElement(By.partialLinkText(" Grandeurstay")).click();
			 //alert accept
			  driver.switchTo().alert().accept();			  
			  driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
			  //alert accept completed			  
			  //tenants module start - applicants			  
			  driver.findElement(By.xpath("//a[@href='/Tenants/tenant_manage']")).click();			 
			  driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
			  driver.findElement(By.xpath("//a[@href='/WaitingLists/tenant_wait']")).click(); 			  
			  //search box 11
			  driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
			  driver.findElement(By.xpath("//input[@aria-controls='tenantView_table']")).sendKeys("1");
			  //view button
			  driver.findElement(By.linkText("View")).click();	
			  //Edit & Approve
			  driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
			  driver.findElement(By.partialLinkText("Edit & Approve")).click();
			  //approve
			//scroll into particular view element
			  WebElement approvelink = driver.findElement(By.id("approve_btn"));
			  scrollIntoView(approvelink, driver);			  
			  //click the approve button
			  driver.findElement(By.id("approve_btn")).click();	
			  
			  //payment
			  driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
			//payment		  
			  driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
			  driver.findElement(By.xpath("//a[@href='/Tenants/payment_tracking/']")).click();
			  //search
			  driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
			  driver.findElement(By.xpath("//input[@aria-controls='all_pay_tbl']")).sendKeys("Bed11app");
			  //action - view details
			  driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
			  driver.findElement(By.linkText("View Details")).click();
			  //action - process
			  driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
			  driver.findElement(By.linkText("Process")).click();
			  //Offline Payment Info
			  //Amount field
			  driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
			  driver.findElement(By.id("partial_pay")).sendKeys(driver.findElement(By.xpath("//*[@id=\"partialpay_ctrl\"]/div/div[2]/div[2]/span")).getText());
			  //payment mode
			  driver.findElement(By.id("TenantPaymentMode")).sendKeys("cash");
			  driver.findElement(By.id("TenantPaymentDetails")).sendKeys("Hand Paymant");
			//scroll into particular view element
			  driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
			  WebElement approvelin = driver.findElement(By.id("the-terms"));
			  scrollIntoView(approvelin, driver);
			//click agree
			  driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
			  driver.findElement(By.id("the-terms")).click();
			//Make Payment
			  driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
			  driver.findElement(By.id("submitBtn")).click(); 
			  //verify
			  
			  
		  
		  }
		  public static void scrollIntoView(WebElement element, WebDriver driver) {
			  JavascriptExecutor jscroll=(JavascriptExecutor)driver;
			  jscroll.executeScript("arguments[0].scrollIntoView(true);",element);
		  }
		  @AfterMethod
			public void closetest() {
				driver.close();
			}
}
