package com.Namfood.Controllers;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.Namfood.Exceptions.MailExists;
import com.Namfood.Entity.PreferenceUser;
import com.Namfood.Entity.User;
import com.Namfood.Service.PreferenceUserService;
import com.Namfood.Service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	PreferenceUserService preferenceService;
	
	@Autowired
	UserService userService;
	
	@PostMapping("/user/signUp")
	@ResponseBody
	public int addUser(@RequestParam User user) throws MailExists {

		return userService.insertUser(user);

	}
	
	@GetMapping("/user/logIn")
	@ResponseBody
	public User logIn (@RequestParam Map<String,String> requestParams){
		String mail = requestParams.get("correo");
		String password = requestParams.get("contraseña");
		return userService.findByMailAndPassword(mail, password);

	}
	
	@GetMapping("/user/profile")
	@ResponseBody
	public PreferenceUser showProfile(@RequestParam User u) {
		PreferenceUser profile = preferenceService.selectWhereMail(u.getMail());
		return profile;
	}
	
	@PostMapping("/user/profile/modify")
	@ResponseBody
	public int modifyProfile(@RequestParam PreferenceUser userPref) {

		return preferenceService.modifyPreferenceUser(userPref);

	}

}
