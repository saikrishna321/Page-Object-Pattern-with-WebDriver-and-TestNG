package org.sayem.pages.login;
import org.sayem.base.Page;
import org.sayem.pages.inbox.LandingPage;
import org.testng.Assert;

public class LoginPage extends Page {
	public LandingPage doLogin(String userName,String password){
		try{
			Assert.assertEquals("XXXWelcome to Facebook � Log in, sign up or learn more", driver.getTitle());
			}catch(Throwable t){
			 Page.takeScreenshot("Login.jpg");
			}
		driver.get(CONFIG.getProperty("testSiteLadingPageURL"));
		System.out.println(isElementPresent("//*[@id='email']"));
		input("EMAIL",userName);
		input("PASSWORD",password);
		click("LOGIN_BUTTON");
		if(isElementPresent("go_to_profile"))
			return new LandingPage();
		else 
			return null;
	}

	public LandingPage doLogin(){
		return doLogin(CONFIG.getProperty("defaultUserName"),CONFIG.getProperty("defaultPassword"));
	}
	
	public void doRegister(){
		
	}
}
