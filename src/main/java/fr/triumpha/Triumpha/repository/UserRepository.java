package fr.triumpha.Triumpha.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

import fr.triumpha.Triumpha.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, String>{

    List<User> findAllByDeletedAtNull();

    Optional<User> findOneByUuid(String uuid);

    User save(User user);

}
