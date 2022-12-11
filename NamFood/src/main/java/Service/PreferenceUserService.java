package Service;

import Model.PreferenceUser;

public interface PreferenceUserService {

	public PreferenceUser selectWhereMail(String mail);
	
	public int modifyPreferenceUser(PreferenceUser pU);
}
