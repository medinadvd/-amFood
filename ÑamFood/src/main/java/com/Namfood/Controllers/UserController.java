package com.Namfood.Controllers;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.Namfood.Entity.PreferenceUser;
import com.Namfood.Entity.User;
import com.Namfood.Service.PreferenceUserService;
import com.Namfood.Service.UserService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/user")
public class UserController {

	@Autowired
	PreferenceUserService preferenceService;

	@Autowired
	UserService userService;
	
	@PostMapping("/signUp")
	public String addUser(@RequestBody User user){
		String msg = userService.insertUser(user);
		if (msg.equals("Usuario registrado satisfactoriamente.")) {
			PreferenceUser userPref = new PreferenceUser();
			userPref.setCorreo(user.getCorreo());
			preferenceService.insertPreferenceUser(userPref);
		}
		return msg;
	}
	
	@PostMapping("/logIn")
	public String logIn(@RequestBody Map<String, String> requestParams) {
		String msg;
		String mail = requestParams.get("correo");
		String password = requestParams.get("password");
		User u = userService.findByMailAndPassword(mail, password);
		if(u!=null) {
			msg = "Inicio de sesión satisfactorio";
		}else {
			msg = "Credenciales no coincidentes";
		}
		return msg;
	}
	
	@GetMapping("/userByMail")
	public User listByMail(@RequestParam String correo) {
		return userService.findUserByMail(correo);
	}
	
	@GetMapping("/listAll")
	public List<User> listAll() {
		return userService.listAll();
	}
	
	@GetMapping("/profile")
	public PreferenceUser showProfile(@RequestBody User user) {
		PreferenceUser profile = preferenceService.selectWhereMail(user.getCorreo());
		return profile;
	}
	
	@PostMapping("/profile/modify")
	public int modifyProfile(@RequestBody PreferenceUser userPref) {
		return preferenceService.modifyPreferenceUser(userPref);
	}

}
