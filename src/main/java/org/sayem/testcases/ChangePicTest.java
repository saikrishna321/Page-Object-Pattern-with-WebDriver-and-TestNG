package org.sayem.testcases;

import org.sayem.base.Page;
import org.sayem.pages.inbox.LandingPage;
import org.sayem.pages.inbox.MyProfilePage;
import org.sayem.pages.login.LoginPage;
import org.sayem.util.TestUtil;
import org.testng.SkipException;
import org.testng.annotations.Test;

public class ChangePicTest {
	
	@Test
	public void changePic(){
		
		if(!TestUtil.isExecutable("ChangePicTest", Page.xls1))
			 throw new SkipException("Runmode set to NO");
		LandingPage landingPage=null;
		if(!Page.isLoggedIn){
			LoginPage loginPage = new LoginPage();
			landingPage= loginPage.doLogin();
		}else{

		}
		
		MyProfilePage profilePage = landingPage.gotoProfile();
	}

}
