package org.sayem.base;


import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.sayem.pages.inbox.TopMenu;
import org.sayem.util.Xls_Reader;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class Page {
	
	public static WebDriver driver = null;
	public static Properties CONFIG =null;
	public static Properties OR =null;
	public static TopMenu topMenu=null;
	public static Xls_Reader xls1= new Xls_Reader("src\\main\\java\\org\\sayem\\xls\\TestCases.xlsx");
	public static boolean isLoggedIn=false;

	public Page(){
		if(driver==null){
		CONFIG= new Properties();
		OR = new Properties();
		try{
			FileInputStream fs = new FileInputStream("src\\main\\java\\org\\sayem\\config\\config.properties");
			CONFIG.load(fs);
			fs = new FileInputStream("src\\main\\java\\org\\sayem\\config\\OR.properties");
			OR.load(fs);
			}catch(Exception e){
				return;
		}
		
		System.out.println(CONFIG.getProperty("browser"));
		if(CONFIG.getProperty("browser").equals("Mozilla"))
		    driver=new FirefoxDriver();
		else if(CONFIG.getProperty("browser").equals("IE"))
		    driver=new InternetExplorerDriver();
		else if(CONFIG.getProperty("browser").equals("Chrome")){
			System.setProperty("webdriver.chrome.driver", "ChromeDriver\\chromedriver");
		    driver=new ChromeDriver();
		}
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		topMenu = new TopMenu();
		
	}
}
	public void click(String xpathKey){
		try{
	        driver.findElement(By.xpath(OR.getProperty(xpathKey))).click();
		}catch(Exception e){
			System.out.println("error");
			e.printStackTrace();
		}
	}
	public void input(String xpathKey, String text){
		try{
		driver.findElement(By.xpath(OR.getProperty(xpathKey))).sendKeys(text);
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	public boolean isElementPresent(String xpathKey){
		try{
			driver.findElement(By.xpath(OR.getProperty(xpathKey)));
		}catch(Exception e){
			return false;
		}
		
		return true;
	}

	public boolean isLinkPresent(String linkText){
		try{
			driver.findElement(By.linkText(linkText));
		}catch(Exception e){
			return false;
		}
		
		return true;
	}
	
	public static void takeScreenshot(String fileName) {
		File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	    try {
			FileUtils.copyFile(scrFile, new File("screenshots\\"+fileName));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
