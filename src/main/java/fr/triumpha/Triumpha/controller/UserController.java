package fr.triumpha.Triumpha.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

import fr.triumpha.Triumpha.dto.CreateUser;
import fr.triumpha.Triumpha.model.User;
import fr.triumpha.Triumpha.service.UserService;
import jakarta.validation.Valid;


@RestController
@RequestMapping("/users")
public class UserController {
    
    private final UserService service;

	@Autowired
	public UserController(UserService service) {
		this.service = service;
	}

	@GetMapping
	public ResponseEntity<List<User>> findAll() {;
		return new ResponseEntity<>(service.findAllUser(), HttpStatus.OK);
	}

	@GetMapping("/{uuid}")
	public ResponseEntity<User> findOneById(@PathVariable String uuid) {
		User user = service.findUserById(uuid);
		if(user != null) {
			return new ResponseEntity<>(service.findUserById(uuid), HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
    
	@PostMapping
	public ResponseEntity<User> save(@Valid @RequestBody CreateUser user) {
		User createdUser = service.create(user);
		return new ResponseEntity<>(createdUser, HttpStatus.CREATED);
	}

}
