package fr.triumpha.Triumpha.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

import fr.triumpha.Triumpha.dto.CreateUser;
import fr.triumpha.Triumpha.model.User;
import fr.triumpha.Triumpha.repository.UserRepository;

@Service
public class UserService {
    
    private final UserRepository repository;

	@Autowired
	public UserService(UserRepository repository) {
		this.repository = repository;
	}

	public List<User> findAllUser() {
		List<User> users = repository.findAll();
		return users;
	}

	public User findUserById(String uuid) {
		return repository.findOneByUuid(uuid).orElse(null);
	}
	
	public User create(CreateUser user) {
		// ici je suis dans la DTO
		User userACreer = new User(
				user.getName(),
				user.getFirstname(),
				user.getEmail(),
				user.getMdp()
		);
		// je suis dans une entité
		return repository.save(userACreer);
	}


}
