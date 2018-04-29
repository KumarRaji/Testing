package test.org;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import test.base.Excelread;
import test.pom.DataCollect;
import test.pom.RegData;

public class Register {
	 WebDriver driver;
		@BeforeMethod
		public void setUp() {
			System.setProperty("webdriver.gecko.driver", "/jars/geckodriver.exe");
			  driver =new FirefoxDriver();
			  driver.get("https://grandeurstay.com/dummy-registration/");
			  driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
			  
		}
  @SuppressWarnings("unlikely-arg-type")
@Test
  public void RegisterTest() throws InterruptedException, AWTException, EncryptedDocumentException, InvalidFormatException, IOException {
	  RegData reg = new RegData(driver);
	  //full name field
	 // driver.findElement(By.name("test_name")).sendKeys("Bed11app");
		reg.typetenantname(Excelread.ExcelData(0, 0));
	  //Company / Institution Name field
	 // driver.findElement(By.name("test_company_inst_name")).sendKeys("siam computing");
		reg.typecompanyname(Excelread.ExcelData(1, 0));
	  //click here to select the room button
	 // driver.findElement(By.className("btn")).click();
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		reg.typesubmitroom();
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		  String parent = driver.getWindowHandle();

			// Perform the click operation that opens new window	// Switch to new window opened
			for(String winHandle : driver.getWindowHandles()){
			    driver.switchTo().window(winHandle);
			}
			driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
			Thread.sleep(2000);
			//Yellow bed select (or) bed selection
			WebElement passelement = driver.findElement(By.xpath("//*[@id=\"floor1\"]/a[3]"));
			Actions action1 = new Actions(driver);
			action1.moveToElement(passelement).click().perform();
			
			 driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
			//parent window
			 driver.switchTo().window(parent);
            //dob
			driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		 //driver.findElement(By.name("test_dob")).click();
		 reg.typedob();
		 
		 //select by year
		   WebElement payclick = driver.findElement(By.className("ui-datepicker-year"));
			Select pay1 = new Select(payclick);
			pay1.selectByValue("2000");
		 //select by date
			WebDriverWait wait=new WebDriverWait(driver, 20);
		    WebElement dateclick;
		    dateclick= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"ui-datepicker-div\"]/table/tbody/tr[1]/td[6]/a")));
		    dateclick.click();
		
		//date of joining field click
		 driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		// driver.findElement(By.name("test_doj")).click();
		 reg.typedoj();
		 
		//select enable dob selection 
		 driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		List<WebElement> dates = driver.findElements(By.xpath("//*[@id=\"ui-datepicker-div\"]/table/tbody/tr//td"));
		int total_node = 31;
		for (int i = 0; i < total_node; i++) {
			String date = dates.get(i).getText();
				if (date.equals('2')|| date.equals("4") || date.equals("6") || date.equals("8") || date.equals("10") || date.equals("12")|| date.equals("14") || date.equals("16") || date.equals("18") || date.equals("20")|| date.equals("22") || date.equals("24") || date.equals("26") || date.equals("28")|| date.equals("30") || date.equals("31")) {
				dates.get(i).click();
				break;
			}			
		}
		//driver.findElement(By.name("test_permanent_address")).sendKeys("a");	
		reg.typepermanentadd(Excelread.ExcelData(2, 0));
		//driver.findElement(By.name("test_office_addr")).sendKeys("a");
		reg.typeofficeadd(Excelread.ExcelData(3, 0));
		//driver.findElement(By.name("test_city")).sendKeys("a");
		reg.typepercity(Excelread.ExcelData(4, 0));
		//driver.findElement(By.name("test_office_city")).sendKeys("a");
		reg.typeoffcity(Excelread.ExcelData(5, 0));
		//driver.findElement(By.name("test_state")).sendKeys("a");
		reg.typeperstate(Excelread.ExcelData(6, 0));
		//driver.findElement(By.name("test_office_state")).sendKeys("a");
		reg.typeoffstate(Excelread.ExcelData(7, 0));
		//driver.findElement(By.name("test_country")).sendKeys("a");
		reg.typepercountry(Excelread.ExcelData(8, 0));
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
	
		//driver.findElement(By.name("test_office_country")).sendKeys("a");		
		reg.typeoffcountry(Excelread.ExcelData(9, 0));
		driver.findElement(By.name("test_pin")).sendKeys("1");
		//reg.typeperpincode(Excelread.ExcelData(0, 2));
		driver.findElement(By.name("test_office_pin")).sendKeys("1");	
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		//reg.typeoffpincode(Excelread.ExcelData(1, 2));
		//driver.findElement(By.name("test_emailid")).sendKeys("kumar@siamcomputing.com");
		reg.typeemailid(Excelread.ExcelData(2, 2));
		driver.findElement(By.name("test_mobile")).sendKeys("9600412153");
		//reg.typemobile(Excelread.ExcelData(3, 2));
		//driver.findElement(By.name("test_father_guard_name")).sendKeys("a");
		reg.typeguardname(Excelread.ExcelData(4, 2));
		driver.findElement(By.name("test_father_guardian_no")).sendKeys("1");
		//reg.typeguradno(Excelread.ExcelData(5, 2));
		JavascriptExecutor scr = (JavascriptExecutor) driver;
		scr.executeScript("scroll(0,700)");
		//Upload your photo field
		Robot r=new Robot();
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		WebElement e = driver.findElement(By.name("test_tenant_photo"));
		Actions action2 = new Actions(driver);
		action2.moveToElement(e).click().perform();  
		StringSelection s=new StringSelection("C:\\Users\\vinoth kumar\\Desktop\\Traiff.jpg");
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(s, null);			
		Thread.sleep(1000);
		r.keyPress(KeyEvent.VK_CONTROL);		
		Thread.sleep(1000);
		r.keyPress(KeyEvent.VK_V);
		Thread.sleep(1000);
		r.keyRelease(KeyEvent.VK_CONTROL);		
		Thread.sleep(1000);
		r.keyRelease(KeyEvent.VK_V);		
		Thread.sleep(1000);
		r.keyPress(KeyEvent.VK_ENTER);
		//Upload your ID Proof field
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		WebElement p = driver.findElement(By.name("test_id_photo"));
		Actions action3 = new Actions(driver);
		action3.moveToElement(p).click().perform();    
		StringSelection s1=new StringSelection("C:\\Users\\vinoth kumar\\Desktop\\Traiff.jpg");
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(s1, null);			
		Thread.sleep(1000);
		r.keyPress(KeyEvent.VK_CONTROL);		
		Thread.sleep(1000);
		r.keyPress(KeyEvent.VK_V);
		Thread.sleep(1000);
		r.keyRelease(KeyEvent.VK_CONTROL);		
		Thread.sleep(1000);
		r.keyRelease(KeyEvent.VK_V);		
		Thread.sleep(1000);
		r.keyPress(KeyEvent.VK_ENTER);
		//Upload your Address Proof field
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		WebElement ad = driver.findElement(By.name("test_addr_photo"));
		Actions action4 = new Actions(driver);
		action4.moveToElement(ad).click().perform();    
		StringSelection s2=new StringSelection("C:\\Users\\vinoth kumar\\Desktop\\Traiff.jpg");
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(s2, null);			
		Thread.sleep(1000);
		r.keyPress(KeyEvent.VK_CONTROL);		
		Thread.sleep(1000);
		r.keyPress(KeyEvent.VK_V);
		Thread.sleep(1000);
		r.keyRelease(KeyEvent.VK_CONTROL);		
		Thread.sleep(1000);
		r.keyRelease(KeyEvent.VK_V);		
		Thread.sleep(1000);
		r.keyPress(KeyEvent.VK_ENTER);	
	
		//recaptcha
	/*	driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		driver.switchTo().defaultContent(); // you are now outside both frames
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@role='presentation']")));
	    WebElement capach = driver.findElement(By.xpath("//div[@role='presentation']"));
		Actions action5 = new Actions(driver);
		action5.moveToElement(capach).click().perform();*/
		
		//send field
		/*driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);		
		driver.findElement(By.id("submitidcontactsubmit")).click();
	  */
	  	 // reg.typecontactsubmit();
  }
  @AfterMethod
	public void closetest() {
		//driver.close();
	}
}
