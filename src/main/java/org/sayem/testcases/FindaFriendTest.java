package org.sayem.testcases;

import org.sayem.base.Page;
import org.sayem.pages.inbox.FriendList;
import org.sayem.pages.inbox.LandingPage;
import org.sayem.pages.inbox.MyProfilePage;
import org.sayem.pages.login.LoginPage;
import org.sayem.util.TestUtil;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.Test;

public class FindaFriendTest {
	
	@Test
	public void findFriend(){
		String friendName="xxxxxx";
		System.out.println("findFriend");
		if(!TestUtil.isExecutable("FindaFriendTest", Page.xls1))
			 throw new SkipException("Runmode set to NO");
		LandingPage landingPage=null;
		if(!Page.isLoggedIn){
			LoginPage loginPage = new LoginPage();
			landingPage= loginPage.doLogin();
		}else{
			landingPage =  Page.topMenu.gotoLandingPage();
		}
		MyProfilePage prof = landingPage.gotoProfile();
		FriendList fs = prof.loadFriendList();
		Assert.assertTrue(fs.searchFriend(friendName), friendName +" - Friend Not Present");
	}
	
	@Test(dependsOnMethods = { "findFriend" })
	public void messageFriend(){
		System.out.println("messageFriend");

	}
}
