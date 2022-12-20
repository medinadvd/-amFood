package com.Namfood.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.Namfood.Entity.Restaurant;

public interface RestaurantRepositoryCustom {
	@Query(value = "SELECT r.id_restaurante, tier_restaurante, nombre, localizacion, tipo_comida, puntuacion, telefono FROM restaurante r INNER JOIN preferencias_restaurante pR ON r.id_restaurante = pR.id_restaurante WHERE col1 = 1 AND r.tier_restaurante = tierNum AND localizacion = gps", nativeQuery = true)
	List<Restaurant> selectWherePreferenceUserColNum1(@Param("col1") String colNombre1, @Param("tier") int tierNum, @Param("gps") String gps);

	@Query(value = "SELECT r.id_restaurante, tier_restaurante, nombre, localizacion, tipo_comida, puntuacion, telefono FROM restaurante r INNER JOIN preferencias_restaurante pR ON r.id_restaurante = pR.id_restaurante WHERE col1 = 1 AND col2 = 1 AND r.tier_restaurante = tierNum AND localizacion = gps", nativeQuery = true)
	List<Restaurant> selectWherePreferenceUserColNum2(@Param("col1") String colNombre1,
			@Param("col2") String colNombre2, @Param("tier") int tierNum, @Param("gps") String gps);

	@Query(value = "SELECT r.id_restaurante, tier_restaurante, nombre, localizacion, tipo_comida, puntuacion, telefono FROM restaurante r INNER JOIN preferencias_restaurante pR ON r.id_restaurante = pR.id_restaurante WHERE col1 = 1 AND col2 = 1 AND col3 = 1 AND r.tier_restaurante = tierNum AND localizacion = gps", nativeQuery = true)
	List<Restaurant> selectWherePreferenceUserColNum3(@Param("col1") String colNombre1,
			@Param("col2") String colNombre2, @Param("col3") String colNombre3, @Param("tier") int tierNum, @Param("gps") String gps);

	@Query(value = "SELECT r.id_restaurante, tier_restaurante, nombre, localizacion, tipo_comida, puntuacion, telefono FROM restaurante r INNER JOIN preferencias_restaurante pR ON r.id_restaurante = pR.id_restaurante WHERE pr.vegetariano = 1  AND pr.vegano = 1 AND pr.halal = 1  AND pr.gluten_free = 1 AND r.tier_restaurante = tierNum AND localizacion = gps", nativeQuery = true)
	List<Restaurant> selectWherePreferenceUserColNum4(@Param("tier") int tierNum, @Param("gps") String gps);
}
