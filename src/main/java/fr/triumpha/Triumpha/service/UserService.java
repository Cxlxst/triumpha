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
		return repository.findAllByDeletedAtNull();
	}

	public User findUserById(String uuid) {
		return repository.findOneByUuid(uuid).orElse(null);
	}
	
	public User create(CreateUser student) {
		// ici je suis dans la DTO
		User studentACreer = new User(
				student.getName(),
				student.getFirstname()
		);
		// je suis dans une entité
		return repository.save(studentACreer);
	}


}
