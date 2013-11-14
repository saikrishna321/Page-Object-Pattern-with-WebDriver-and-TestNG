package org.sayem.pages.inbox;
import org.sayem.base.Page;

public class MyProfilePage extends Page {
	public void changePic(String newPicPath){
		click("edit_profile_pic");
		input("file_upload", newPicPath);
	}
	public FriendList loadFriendList(){
		click("friends_link");
		return new FriendList();
	}
}
