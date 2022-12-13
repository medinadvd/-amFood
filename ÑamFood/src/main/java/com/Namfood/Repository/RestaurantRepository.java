package com.Namfood.Repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Namfood.Entity.PreferenceUser;


@Repository
public interface RestaurantRepository extends JpaRepository<PreferenceUser, String>, RestaurantRepositoryCustom {

}
