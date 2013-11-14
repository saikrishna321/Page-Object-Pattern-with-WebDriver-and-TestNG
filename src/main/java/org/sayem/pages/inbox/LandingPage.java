package org.sayem.pages.inbox;

import org.sayem.base.Page;

public class LandingPage extends Page {
	public MyProfilePage gotoProfile(){
     click("go_to_profile");
     return new MyProfilePage();
	
	}
}
