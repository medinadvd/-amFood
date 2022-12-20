package com.Namfood.Controllers;

import java.util.List;
import java.util.Map;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.Namfood.Entity.PreferenceUser;
import com.Namfood.Entity.Restaurant;
import com.Namfood.Service.PreferenceUserService;
import com.Namfood.Service.RestaurantService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/restaurant")
public class RestaurantController {
	
	@Autowired
	RestaurantService restService;
	
	@Autowired
	PreferenceUserService userPService;
	
	@PostMapping("")
	@ResponseBody
	public Restaurant getRestaurantList(@RequestBody Map<String, String> requestParams) {
		String mail = requestParams.get("correo");
		String gps = requestParams.get("localizacion");
		PreferenceUser profile = userPService.selectWhereMail(mail);
		int indiceRest, randomTier;
		List<Restaurant> restList;
		Random randomNumTier = new Random();
	    randomTier = randomNumTier.nextInt(9);
	    System.out.println("-----------------------------------------------------------");
		if(randomTier<5) {			
			restList =  restService.selectWhereRestaurantTier(profile, 1, gps);
			System.out.println("LLEGOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOO");
			System.out.println(restList);
		}else if(randomTier>4 && randomTier<8){
			restList = restService.selectWhereRestaurantTier(profile, 2, gps);
			System.out.println(restList);
		}else {
			restList = restService.selectWhereRestaurantTier(profile, 3, gps);
			System.out.println(restList);
		}
		Random randomNum = new Random();
	    indiceRest = randomNum.nextInt(restList.size());
		return restList.get(indiceRest);
	}
	
	@GetMapping("/listAll")
	@ResponseBody
	public List<Restaurant> listAll() {
		return restService.listAll();
	}
	
}
