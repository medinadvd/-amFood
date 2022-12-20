package com.Namfood.Repository;

import java.util.List;

import com.Namfood.Entity.Restaurant;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;

public class RestaurantRepositoryImpl implements RestaurantRepositoryCustom {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public List<Restaurant> selectWherePreferenceUserColNum1(String colNombre1, int tierNum, String gps) {
		TypedQuery<Restaurant> query = entityManager.createQuery(
				"SELECT r FROM Restaurant r INNER JOIN PreferenceRest pR ON r.id_restaurante = pR.id_restaurante WHERE "
						+ colNombre1 + " = 1 AND r.tier_restaurante = " + tierNum + "AND r.localizacion = '" + gps
						+ "'",
				Restaurant.class);
		List<Restaurant> results = query.getResultList();
		return results;
	}

	@Override
	public List<Restaurant> selectWherePreferenceUserColNum2(String colNombre1, String colNombre2, int tierNum,
			String gps) {
		TypedQuery<Restaurant> query = entityManager.createQuery(
				"SELECT r FROM Restaurant r INNER JOIN PreferenceRest pR ON r.id_restaurante = pR.id_restaurante WHERE "
						+ colNombre1 + " = 1 AND " + colNombre2 + " = 1 AND r.tier_restaurante = " + tierNum
						+ " AND r.localizacion = '" + gps + "'",
				Restaurant.class);
		List<Restaurant> results = query.getResultList();
		return results;
	}

	@Override
	public List<Restaurant> selectWherePreferenceUserColNum3(String colNombre1, String colNombre2, String colNombre3,
			int tierNum, String gps) {
		TypedQuery<Restaurant> query = entityManager.createQuery(
				"SELECT r FROM restaurante r INNER JOIN PreferenceRest pR ON r.id_restaurante = pR.id_restaurante WHERE "
						+ colNombre1 + " = 1 AND " + colNombre2 + " = 1 AND " + colNombre3
						+ " = 1 AND r.tier_restaurante = " + tierNum + " AND r.localizacion = '" + gps + "'",
				Restaurant.class);
		List<Restaurant> results = query.getResultList();
		return results;
	}

	@Override
	public List<Restaurant> selectWherePreferenceUserColNum4(int tierNum, String gps) {
		TypedQuery<Restaurant> query = entityManager.createQuery(
				"SELECT r FROM restaurante r INNER JOIN PreferenceRest pR ON r.id_restaurante = pR.id_restaurante WHERE pr.vegetariano = 1  AND pr.vegano = 1 AND pr.halal = 1  AND pr.gluten_free = 1 AND r.tier_restaurante = "
						+ tierNum + " AND r.localizacion = '" + gps + "'",
				Restaurant.class);
		List<Restaurant> results = query.getResultList();
		return results;
	}

}
