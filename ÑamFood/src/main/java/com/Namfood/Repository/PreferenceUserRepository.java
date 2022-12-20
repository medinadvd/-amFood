package com.Namfood.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.Namfood.Entity.PreferenceUser;

@Repository
public interface PreferenceUserRepository extends JpaRepository<PreferenceUser, String> {
	
	PreferenceUser findByCorreo(String mail);
	
	@Transactional
	@Modifying
	@Query(value = "update preferencias_user up set up.vegetariano = ?1, up.vegano = ?2, up.halal = ?3, up.gluten_free = ?4 where up.Correo = ?5", nativeQuery = true)
	int updatePreferenceUser(int vege, int vegan, int halal, int glutenfree, String mail);
}
