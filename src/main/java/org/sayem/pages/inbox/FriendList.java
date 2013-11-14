package org.sayem.pages.inbox;

import org.sayem.base.Page;

public class FriendList extends Page {
	public boolean searchFriend(String friendName){
		input("friend_search_name", friendName);
		return isLinkPresent(friendName);
	}
}
