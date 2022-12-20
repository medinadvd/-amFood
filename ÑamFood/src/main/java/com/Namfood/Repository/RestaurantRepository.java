package com.Namfood.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Namfood.Entity.Restaurant;


@Repository
public interface RestaurantRepository extends JpaRepository<Restaurant, String>, RestaurantRepositoryCustom{
}
