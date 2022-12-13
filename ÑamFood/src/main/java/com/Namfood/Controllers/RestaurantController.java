package com.Namfood.Controllers;

import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.Namfood.Entity.PreferenceUser;
import com.Namfood.Entity.Restaurant;
import com.Namfood.Entity.User;
import com.Namfood.Service.PreferenceUserService;
import com.Namfood.Service.RestaurantService;

@RestController
@RequestMapping("/restaurant")
public class RestaurantController {
	
	@Autowired
	RestaurantService restService;
	
	@Autowired
	PreferenceUserService userPService;
	
	@GetMapping("/restaurant")
	@ResponseBody
	public Restaurant getRestaurantList(@RequestParam User u) {
		PreferenceUser profile = userPService.selectWhereMail(u.getMail());
		int indiceRest, randomTier;
		List<Restaurant> restList;
		Random randomNumTier = new Random();
	    randomTier = randomNumTier.nextInt(9);
		if(randomTier<5) {
			restList =  restService.selectWhereRestaurantTier(profile, 1);
		}else if(randomTier>4 && randomTier<8){
			restList = restService.selectWhereRestaurantTier(profile, 2);
		}else {
			restList = restService.selectWhereRestaurantTier(profile, 3);
		}
		//List<Restaurant> restList = restService.selectWhereUserPreference(profile);
		
		Random randomNum = new Random();
	    indiceRest = randomNum.nextInt(restList.size());
		return restList.get(indiceRest);
	}
	
}
