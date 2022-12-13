package com.Namfood.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Namfood.Entity.History;

@Repository
public interface HistoryRepository extends JpaRepository<History, String> {
	public List<History> findByMail(String mail);
	public List<History> findByMailAndFav(String mail, String fav);
}
