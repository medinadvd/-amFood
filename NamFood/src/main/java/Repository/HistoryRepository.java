package Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import Model.History;

@Repository
public interface HistoryRepository extends JpaRepository<History, String> {
	public List<History> findByFavorito(String mail);
}
