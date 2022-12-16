package com.Namfood.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.Namfood.Entity.History;

public interface HistoryRepositoryCustom {
	
	@Query(value = "SELECT * FROM historial WHERE correo = mail AND favorito = 1", nativeQuery = true)
	List<History> selectWhereCorreoAndFavorito(@Param("mail") String mail);
	
}
