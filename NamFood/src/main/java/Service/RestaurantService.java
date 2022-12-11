package Service;

import java.util.List;

import Model.PreferenceUser;
import Model.Restaurant;

public interface RestaurantService {
	List<Restaurant> selectWhereUserPreference(PreferenceUser pU);
}
