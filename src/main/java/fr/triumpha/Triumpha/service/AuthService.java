package fr.triumpha.Triumpha.service;

import fr.triumpha.Triumpha.constants.Role;
import fr.triumpha.Triumpha.dto.LoginDto;
import fr.triumpha.Triumpha.dto.RegisterDto;
import fr.triumpha.Triumpha.UtilisateurRepository;
import fr.triumpha.Triumpha.model.User;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {
	private final UtilisateurRepository UtilisateurRepository;

	private final PasswordEncoder passwordEncoder;

	private final AuthenticationManager authenticationManager;

	public AuthService(
			UtilisateurRepository UtilisateurRepository,
			AuthenticationManager authenticationManager,
			PasswordEncoder passwordEncoder
	) {
		this.authenticationManager = authenticationManager;
		this.UtilisateurRepository = UtilisateurRepository;
		this.passwordEncoder = passwordEncoder;
	}

	public User signup(RegisterDto input) {
		User user = new User();
		user.setName(input.getName());
		user.setFirstname(input.getFirstname());
		user.setUsername(input.getEmail());
		user.setRole(Role.USER);
		user.setPassword(passwordEncoder.encode(input.getMdp()));

		return UtilisateurRepository.save(user);
	}

	public User authenticate(LoginDto input) {
		authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(
						input.getEmail(),
						input.getPassword()
				)
		);

		return UtilisateurRepository.findByEmail(input.getEmail())
				.orElseThrow();
	}
}