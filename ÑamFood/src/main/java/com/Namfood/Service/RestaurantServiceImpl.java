package com.Namfood.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Namfood.Entity.PreferenceUser;
import com.Namfood.Entity.Restaurant;
import com.Namfood.Repository.RestaurantRepository;

@Service
public class RestaurantServiceImpl implements RestaurantService {

	@Autowired
	RestaurantRepository rR;

	@Override
	public List<Restaurant> selectWhereRestaurantTier(PreferenceUser pU, int tier) {
		int opc = 0;
		String col1 = null, col2 = null, col3 = null;
		if (pU.isVege()) {
			opc++;
			col1 = "pR.vegetariano";
		}
		if (pU.isVegan()) {
			opc++;
			if (col1 != null) {
				col2 = "pr.vegano";
			} else {
				col1 = "pr.vegano";
			}
		}
		if (pU.isHalal()) {
			opc++;
			if (col1 != null) {
				if (col2 != null) {
					col3 = "pr.halal";
				} else {
					col2 = "pr.halal";
				}
			} else {
				col1 = "pr.halal";
			}
		}
		if (pU.isGlutenfree()) {
			opc++;
			if (col1 != null) {
				if (col2 != null) {
					if (col3 == null) {
						col3 = "pr.gluten_free";
					}
				} else {
					col2 = "pr.gluten_free";
				}
			} else {
				col1 = "pr.gluten_free";
			}
		}
		
		switch(opc) {
			case 0:
				return null;
				//return rR.findAll();
			case 1:
				//return rR.selectWherePreferenceUserColNum1(col1, tier);
			case 2:
				//return rR.selectWherePreferenceUserColNum2(col1, col2, tier);
			case 3:
				//return rR.selectWherePreferenceUserColNum3(col1, col2, col3, tier);
			case 4:
				//return rR.selectWherePreferenceUserColNum4(tier);
		}

		return null;
	}

	
	/*@Override
	public List<Restaurant> selectWhereUserPreference(PreferenceUser pU) {
		int opc = 0;
		String col1 = null, col2 = null, col3 = null;
		if (pU.isVege()) {
			opc++;
			col1 = "pR.vegetariano";
		}
		if (pU.isVegan()) {
			opc++;
			if (col1 != null) {
				col2 = "pr.vegano";
			} else {
				col1 = "pr.vegano";
			}
		}
		if (pU.isHalal()) {
			opc++;
			if (col1 != null) {
				if (col2 != null) {
					col3 = "pr.halal";
				} else {
					col2 = "pr.halal";
				}
			} else {
				col1 = "pr.halal";
			}
		}
		if (pU.isGlutenfree()) {
			opc++;
			if (col1 != null) {
				if (col2 != null) {
					if (col3 == null) {
						col3 = "pr.gluten_free";
					}
				} else {
					col2 = "pr.gluten_free";
				}
			} else {
				col1 = "pr.gluten_free";
			}
		}
		
		switch(opc) {
			case 0:
				return rR.findAll();
			case 1:
				return rR.selectWherePreferenceUserColNum1(col1);
			case 2:
				return rR.selectWherePreferenceUserColNum2(col1, col2);
			case 3:
				return rR.selectWherePreferenceUserColNum3(col1, col2, col3);
			case 4:
				return rR.selectWherePreferenceUserColNum4();
		}

		return null;
	}*/

}
