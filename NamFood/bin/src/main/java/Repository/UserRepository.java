package Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import Model.User;

@Repository
public interface UserRepository extends JpaRepository<User, String> {
	
	User findByCorreo(String mail);
	
}