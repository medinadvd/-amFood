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
	
	PreferenceUser findByMail(String mail);
	
	@Transactional
	@Modifying
	@Query(value = "update preferencias_user up set up.vegetariano = vege, up.vegano = vegan, up.halal = halal, up.gluten_free = glutenfree where up.Correo = mail", nativeQuery = true)
	int updatePreferenceUser(@Param("vege") Boolean vege, @Param("vegan") Boolean vegan, @Param("halal") Boolean halal,
			@Param("glutenfree") Boolean glutenfree, @Param("mail") String mail);
}
