package test.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.testng.annotations.Test;

public class Property_base {
	 @Test
	  public static void chrome() throws IOException {
		  File src = new File("./configure/config.property");
		  FileInputStream fis = new FileInputStream(src);
		  Properties pro = new Properties();
		  pro.load(fis);
		  String chromepath = pro.getProperty("ChromeDriver");
		  System.setProperty("webdriver.chrome.driver", chromepath);
		 	   
	  }
	  
	  @Test
	  public static void fire() throws IOException {
		  File src = new File("./configure/config.property");
		  FileInputStream fis = new FileInputStream(src);
		  Properties pro = new Properties();
		  pro.load(fis);
		  String firefoxpath = pro.getProperty("FirefoxDriver");
		  System.setProperty("webdriver.chrome.driver", firefoxpath);

		  
	  }
	  @Test
	  public static void urlget() throws IOException {
		  File src = new File("./configure/config.property");
		  FileInputStream fis = new FileInputStream(src);
		  Properties pro = new Properties();
		  pro.load(fis);
		  String urlpath = pro.getProperty("URL");
		  System.setProperty("webdriver.chrome.driver", urlpath);
		  
		 
	  }
	  
	  
	}
