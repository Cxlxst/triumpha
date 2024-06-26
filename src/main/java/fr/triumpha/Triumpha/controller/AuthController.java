package fr.triumpha.Triumpha.controller;

import fr.triumpha.Triumpha.dto.LoginDto;
import fr.triumpha.Triumpha.dto.LoginResponse;
import fr.triumpha.Triumpha.dto.RegisterDto;
import fr.triumpha.Triumpha.model.User;
import fr.triumpha.Triumpha.service.AuthService;
import fr.triumpha.Triumpha.security.JwtService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/auth")
@RestController
public class AuthController {
	private final JwtService jwtService;

	private final AuthService authenticationService;

	public AuthController(JwtService jwtService, AuthService authenticationService) {
		this.jwtService = jwtService;
		this.authenticationService = authenticationService;
	}

	@PostMapping("/signup")
	public ResponseEntity<User> register(@RequestBody RegisterDto registerUserDto) {
		User registeredUser = authenticationService.signup(registerUserDto);
		return new ResponseEntity<>(registeredUser, HttpStatus.CREATED);
	}

	@PostMapping("/login")
	public ResponseEntity<LoginResponse> authenticate(
			@RequestBody LoginDto loginUserDto) {
		UserDetails authenticatedUser = authenticationService.authenticate(loginUserDto);

		String jwtToken = jwtService.generateToken(authenticatedUser);

		LoginResponse loginResponse = new LoginResponse();
		loginResponse.setToken(jwtToken);
		loginResponse.setExpiresIn(jwtService.getExpirationTime());

		return new ResponseEntity<>(loginResponse, HttpStatus.OK);
	}
}
