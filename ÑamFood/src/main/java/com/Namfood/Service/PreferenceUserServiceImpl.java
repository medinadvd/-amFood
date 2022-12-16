package com.Namfood.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Namfood.Entity.PreferenceUser;
import com.Namfood.Repository.PreferenceUserRepository;

@Service
public class PreferenceUserServiceImpl implements PreferenceUserService{
	
	@Autowired
	PreferenceUserRepository pU;
	
	@Override
	public PreferenceUser selectWhereMail(String mail) {
		return pU.findByMail(mail);
	}
	
	@Override
	public int modifyPreferenceUser(PreferenceUser p) {
		
		return pU.updatePreferenceUser(p.isVegetariano(), p.isVegano(), p.isHalal(), p.isGluten_free(), p.getCorreo());
	}

	@Override
	public void insertPreferenceUser(PreferenceUser userPrefNew) {
		pU.save(userPrefNew);
	}

}
