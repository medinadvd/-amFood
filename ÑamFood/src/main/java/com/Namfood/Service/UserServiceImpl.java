package com.Namfood.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Namfood.Entity.User;
import com.Namfood.Exceptions.MailExists;
import com.Namfood.Repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	UserRepository uR;
	
	@Override
	public User findUserByMail(String mail) {
		return uR.findByMail(mail);
	}

	@Override
	public int insertUser(User userNew) throws MailExists {
		User u = uR.findByMail(userNew.getMail());
		if (u==null) {
           uR.save(userNew);
        }else {
        	 throw new MailExists("There is already a user with mail");
        }
		return 0;
	}

	@Override
	public User findByMailAndPassword(String mail, String password) {
		return uR.findByMailAndPassword(mail, password);
	}

}
