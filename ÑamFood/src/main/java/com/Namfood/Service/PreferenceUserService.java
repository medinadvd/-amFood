package com.Namfood.Service;

import com.Namfood.Entity.PreferenceUser;

public interface PreferenceUserService {

	public PreferenceUser selectWhereMail(String mail);
	
	public int modifyPreferenceUser(PreferenceUser pU);
	
	public void insertPreferenceUser(PreferenceUser userPrefNew);
}
