package com.Namfood.Service;

import com.Namfood.Entity.User;
import com.Namfood.Exceptions.MailExists;

public interface UserService {
	
	public User findUserByMail(String mail);
	
	public User findByMailAndPassword(String mail, String password);
	
	public int insertUser(User userNew) throws MailExists;
	
}
