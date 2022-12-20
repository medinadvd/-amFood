package com.Namfood.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Namfood.Entity.PreferenceUser;
import com.Namfood.Entity.Restaurant;
import com.Namfood.Entity.RestaurantDto;
import com.Namfood.Repository.RestaurantRepository;

@Service
public class RestaurantServiceImpl implements RestaurantService {

	@Autowired
	RestaurantRepository rR;

	@Override
	public List<Restaurant> selectWhereRestaurantTier(PreferenceUser pU, int tier, String gps) {
		int opc = 0;
		List<Restaurant> res = null;
		String col1 = null, col2 = null, col3 = null;
		if (pU.getVegetariano() == 1) {
			opc++;
			col1 = "vegetariano";
		}
		if (pU.getVegano() == 1) {
			opc++;
			if (col1 != null) {
				col2 = "vegano";
			} else {
				col1 = "vegano";
			}
		}
		if (pU.getHalal() == 1) {
			opc++;
			if (col1 != null) {
				if (col2 != null) {
					col3 = "halal";
				} else {
					col2 = "halal";
				}
			} else {
				col1 = "halal";
			}
		}
		if (pU.getGluten_free() == 1) {
			opc++;
			if (col1 != null) {
				if (col2 != null) {
					if (col3 == null) {
						col3 = "gluten_free";
					}
				} else {
					col2 = "gluten_free";
				}
			} else {
				col1 = "gluten_free";
			}
		}
		
		switch(opc) {
			case 0:
				return rR.findAll();
			case 1:
				return rR.selectWherePreferenceUserColNum1(col1, tier, gps);
			case 2:
				return rR.selectWherePreferenceUserColNum2(col1, col2, tier, gps);
			case 3:
				return rR.selectWherePreferenceUserColNum3(col1, col2, col3, tier, gps);
			case 4:
				return rR.selectWherePreferenceUserColNum4(tier, gps);
		}
		
		return null;

	}

	@Override
	public List<Restaurant> listAll() {
		return rR.findAll();
	}


}
