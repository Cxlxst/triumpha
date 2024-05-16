package fr.triumpha.Triumpha;

import fr.triumpha.Triumpha.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UtilisateurRepository extends CrudRepository<User, Integer> {
	Optional<User> findByEmail(String email);
}