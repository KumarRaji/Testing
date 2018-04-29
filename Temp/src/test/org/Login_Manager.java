package test.org;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import test.pom.DataCollect;

public class Login_Manager {

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
			  driver.findElement(By.partialLinkText(" Grandeurstay")).click();
			  //alert cancel
			  driver.switchTo().alert().dismiss();
			  Assert.assertEquals(driver.findElement(By.partialLinkText("Grandeurstay")).getText(), "Grandeurstay");
		  }
		  @Test(priority=2)
		  public void tenantInfo() throws InterruptedException {

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
			  driver.findElement(By.xpath("//input[@aria-controls='tenantView_table']")).sendKeys("3");
			  //view button
			  driver.findElement(By.linkText("View")).click();			  
			  //Tenant info
			  driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
			  driver.findElement(By.linkText("Tenant Info")).click();
			  String parent = driver.getWindowHandle();

				// Perform the click operation that opens new window	// Switch to new window opened
				for(String winHandle : driver.getWindowHandles()){
				    driver.switchTo().window(winHandle);
				}
				driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
				//verify the pdf for tenant info
				//after close based remove (close)
				driver.close();
				//driver.switchTo().window(parent);
		  }	  

		  
		  @Test(priority=3)
		  public void viewrejectCancel() throws InterruptedException {

			  driver.findElement(By.id("UserUsername")).sendKeys("khuze");
			  driver.findElement(By.id("UserPassword")).sendKeys("siam123");
			  driver.findElement(By.xpath("//button[@type='submit']")).click();
			  driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
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
			  driver.findElement(By.xpath("//input[@aria-controls='tenantView_table']")).sendKeys("3");
			  //view button
			  driver.findElement(By.linkText("View")).click();			  
			  //Reject
			  driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
			  driver.findElement(By.linkText("Reject")).click();
			  //reject alert cancel
			  driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
			  driver.switchTo().alert().dismiss();
			  //verify the Reject cancel
			  driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
			  Assert.assertEquals(driver.findElement(By.linkText("Reject")).getText(), "Reject");
		  } 
		  
		  	  
		  @Test(priority=4)
		  //new tenant register
	      public void editandApprove() throws InterruptedException {

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
		  driver.findElement(By.xpath("//input[@aria-controls='tenantView_table']")).sendKeys("3");
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
		  //verify the success message
		  Assert.assertEquals(driver.findElement(By.partialLinkText("The Tenant has been approved and payment link will be sent.")).getText(), "The Tenant has been approved and payment link will be sent.");
				  
		  }
		  
		  @Test(priority=5)
		      public void approveReject_Cancel() throws InterruptedException {

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
			  driver.findElement(By.xpath("//input[@aria-controls='tenantView_table']")).sendKeys("7");
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
			  //verify the success message
			  driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
			  Assert.assertEquals(driver.findElement(By.linkText("Edit")).getText(), "Edit");
			  //Reject
			  driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
			  driver.findElement(By.linkText("Reject")).click();
			  //dismiss the alert
			  driver.switchTo().alert().dismiss();
			  //verify the Reject cancel
			  driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
			  Assert.assertEquals(driver.findElement(By.linkText("Reject")).getText(), "Reject");
		  } 
		  @Test(priority=6)
	      public void viewapproveRejecT() throws InterruptedException {

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
			  //Reject
			  driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
			  driver.findElement(By.linkText("Reject")).click();
			  //search box 11
			  Thread.sleep(2000);
			  driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
			  Assert.assertEquals(driver.findElement(By.partialLinkText("Re-Queue")).getText(), "Re-Queue");
		  } 

		  
		  
			  
		/*	 //Edit & Approve
			  driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
			  driver.findElement(By.partialLinkText("Edit & Approve")).click();
			  
			  //approve
			  driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
			  driver.findElement(By.id("approve_btn")).click();*/
			  			  
			  
			  
		  
	
		//until scroll particular element present
		  
		  public static void scrollIntoView(WebElement element, WebDriver driver) {
		  JavascriptExecutor jscroll=(JavascriptExecutor)driver;
		  jscroll.executeScript("arguments[0].scrollIntoView(true);",element);
	  }
	  
		  @AfterMethod
			public void closetest() {
				driver.close();
			}
		}
