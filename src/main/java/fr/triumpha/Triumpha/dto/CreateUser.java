package fr.triumpha.Triumpha.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class CreateUser {
    
    @NotBlank
	@Size(min = 1, max = 25)
	private String name;

	@NotBlank
	private String firstname;

	public CreateUser(String name, String firstname) {
		this.name = name;
		this.firstname = firstname;
	}

	public String getName() {
		return name;
	}

	public String getFirstname() {
		return firstname;
	}
    

}
