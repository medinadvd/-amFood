package com.Namfood.Repository;

import java.util.List;

import com.Namfood.Entity.Restaurant;
import com.Namfood.Entity.RestaurantDto;


public interface RestaurantRepositoryCustom {
	
	List<Restaurant> selectWherePreferenceUserColNum1(String colNombre1, int tierNum, String gps);
	
	List<Restaurant> selectWherePreferenceUserColNum2(String colNombre1, String colNombre2, int tierNum, String gps);

	List<Restaurant> selectWherePreferenceUserColNum3(String colNombre1, String colNombre2, String colNombre3, int tierNum, String gps);
	
	List<Restaurant> selectWherePreferenceUserColNum4(int tierNum, String gps);
}
