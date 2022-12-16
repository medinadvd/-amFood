package com.Namfood.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Namfood.Entity.User;
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
	public String insertUser(User userNew) {
		User u = uR.findByMail(userNew.getCorreo());
		String msg = "";
		if (u == null) {
			uR.save(userNew);
			msg = "Usuario registrado satisfactoriamente.";
		} else {
			msg = "Ya existe un usuario registrado con este correo.";
		}
		return msg;
	}

	@Override
	public User findByMailAndPassword(String mail, String password) {
		return uR.findByMailAndPassword(mail, password);
	}

	@Override
	public List<User> listAll() {
		return uR.findAll();
	}

}
