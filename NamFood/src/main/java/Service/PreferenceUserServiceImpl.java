package Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Model.PreferenceUser;
import Repository.PreferenceUserRepository;

@Service
public class PreferenceUserServiceImpl implements PreferenceUserService {
	
	@Autowired
	PreferenceUserRepository pU;
	
	@Override
	public PreferenceUser selectWhereMail(String mail) {
		return pU.findByCorreo(mail);
	}

	@Override
	public int modifyPreferenceUser(PreferenceUser p) {
		return pU.updatePreferenceUser(p.isVege(), p.isVegan(), p.isHalal(), p.isGlutenfree(), p.getMail());
	}

}
