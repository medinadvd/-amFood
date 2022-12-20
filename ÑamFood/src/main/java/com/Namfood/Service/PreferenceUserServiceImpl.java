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
		return pU.findByCorreo(mail);
	}
	
	@Override
	public int modifyPreferenceUser(PreferenceUser p) {
		
		return pU.updatePreferenceUser(p.getVegetariano(), p.getVegano(), p.getHalal(), p.getGluten_free(), p.getCorreo());
	}

	@Override
	public void insertPreferenceUser(PreferenceUser userPrefNew) {
		pU.save(userPrefNew);
	}

}
