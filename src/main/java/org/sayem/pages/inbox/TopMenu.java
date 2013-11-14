package org.sayem.pages.inbox;

import org.openqa.selenium.By;
import org.sayem.base.Page;

public class TopMenu {
	public void Logout(){
		Page.driver.findElement(By.xpath(Page.OR.getProperty("top_menu_list"))).click();
		Page.driver.findElement(By.xpath(Page.OR.getProperty("top_menu_logout"))).click();
	}
	public void search(String searchText){
		
	}
	public LandingPage gotoLandingPage(){
		Page.driver.findElement(By.xpath(Page.CONFIG.getProperty("homePage_link"))).click();
		return new LandingPage();
	}
}
