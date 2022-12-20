package com.Namfood.Service;

import java.util.List;

import com.Namfood.Entity.User;

public interface UserService {
	
	public User findUserByMail(String mail);
	
	public User findByMailAndPassword(String mail, String password);
	
	public String insertUser(User userNew);
	
	public List<User> listAll();
	
}
