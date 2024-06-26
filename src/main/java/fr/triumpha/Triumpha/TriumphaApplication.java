package fr.triumpha.Triumpha;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@RequestMapping("/")
public class TriumphaApplication {

	public static void main(String[] args) {
		SpringApplication.run(TriumphaApplication.class, args);
	}

	@GetMapping("test")
	public String testFonctionnent()
	{
		return "Test fonctionnement";
	}
}
