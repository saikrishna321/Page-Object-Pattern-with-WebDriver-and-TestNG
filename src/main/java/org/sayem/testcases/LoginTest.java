package org.sayem.testcases;

import org.sayem.base.Page;
import org.sayem.pages.inbox.LandingPage;
import org.sayem.pages.login.LoginPage;
import org.sayem.util.ErrorUtil;
import org.sayem.util.TestUtil;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Hashtable;

public class LoginTest {

	@Test(dataProvider="getData")
	public void loginTest(Hashtable<String,String> data){
		if(!TestUtil.isExecutable("LoginTest", Page.xls1))
		 throw new SkipException("Runmode set to NO");
		if(!data.get("Runmode").equals("Y"))
			 throw new SkipException("Runmode set to NO for the data set");
		System.out.println(data.get("Runmode")+" -- "+data.get("Username") +" -- "+data.get("Password"));

		if(Page.isLoggedIn){
			Page.topMenu.Logout();
			Page.isLoggedIn=false;
		}
		String testDataType=data.get("Flag");
		LoginPage loginPage = new LoginPage();
		
		
		LandingPage page= loginPage.doLogin(data.get("Username"), data.get("Password"));
		if(testDataType.equals("Y") & page==null){
			try{
			Assert.assertTrue(false, "Not able to login with correct data ");
			}catch(Throwable t){
				Page.takeScreenshot("Login");
				ErrorUtil.addVerificationFailure(t);
			}
			Page.isLoggedIn=false;
			return;
		}
		else if(!testDataType.equals("Y") & page!=null ){
			Assert.assertTrue(false, "Able to login with incorrect data ");
			Page.isLoggedIn=false;	
			return;
		}
		
		if(testDataType.equals("Y"))
		 Page.isLoggedIn=true;
		else
		 Page.isLoggedIn=false;

	}
	@DataProvider
	public Object[][] getData(){
		return TestUtil.getData("LoginTest", Page.xls1);
	}
}
