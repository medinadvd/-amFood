package com.Namfood.Service;

import java.util.List;

import com.Namfood.Entity.PreferenceUser;
import com.Namfood.Entity.Restaurant;

public interface RestaurantService {
	
	//List<Restaurant> selectWhereUserPreference(PreferenceUser pU);
	
	List<Restaurant> listAll();

	List<Restaurant> selectWhereRestaurantTier(PreferenceUser pU, int tier, String gps);
}
