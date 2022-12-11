package Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import Model.Restaurant;

@Repository
public interface RestaurantRepository extends JpaRepository<Restaurant, String> {

	@Query("SELECT r FROM restaurante r INNER JOIN preferencias_restaurante pR ON r.idrestaurante = pR.idrestaurante WHERE col1 = 1")
	List<Restaurant> selectWherePreferenceUserColNum1(@Param("col1") String colNombre1);

	@Query("SELECT r FROM restaurante r INNER JOIN preferencias_restaurante pR ON r.idrestaurante = pR.idrestaurante WHERE col1 = 1 AND col2 = 1")
	List<Restaurant> selectWherePreferenceUserColNum2(@Param("col1") String colNombre1,
			@Param("col2") String colNombre2);

	@Query("SELECT r FROM restaurante r INNER JOIN preferencias_restaurante pR ON r.idrestaurante = pR.idrestaurante WHERE col1 = 1 AND col2 = 1 AND col3 = 1")
	List<Restaurant> selectWherePreferenceUserColNum3(@Param("col1") String colNombre1,
			@Param("col2") String colNombre2, @Param("col3") String colNombre3);

	@Query("SELECT r FROM restaurante r INNER JOIN preferencias_restaurante pR ON r.idrestaurante = pR.idrestaurante WHERE pr.vegetariano = 1  AND pr.vegano = 1 AND pr.halal = 1  AND pr.gluten_free = 1")
	List<Restaurant> selectWherePreferenceUserColNum4();

}