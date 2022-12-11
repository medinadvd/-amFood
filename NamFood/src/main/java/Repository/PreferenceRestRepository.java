package Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import Model.PreferenceRest;

@Repository
public interface PreferenceRestRepository extends JpaRepository<PreferenceRest, Integer> {
}