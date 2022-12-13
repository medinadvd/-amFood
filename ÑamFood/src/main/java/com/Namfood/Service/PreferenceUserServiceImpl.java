package com.Namfood.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Namfood.Entity.PreferenceUser;
import com.Namfood.Repository.PreferenceUserRepository;

@Service
public class PreferenceUserServiceImpl implements PreferenceUserService{
	
	@Autowired
	PreferenceUserRepository pU;
	
	public PreferenceUser selectWhereMail(String mail) {
		return pU.findByMail(mail);
	}

	public int modifyPreferenceUser(PreferenceUser p) {
		
		return pU.updatePreferenceUser(p.isVege(), p.isVegan(), p.isHalal(), p.isGlutenfree(), p.getMail());
	}

}
