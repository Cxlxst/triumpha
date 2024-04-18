package fr.triumpha.Triumpha.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class CreateUser {
    
    @NotBlank
	@Size(min = 1, max = 25)
	private String name;

	@NotBlank
	private String firstname;

	//Add control mail (Aa.Bb@Cc.com)
	@NotBlank
	private String email;

	//Add control mdp (maj, min, 0-9, !)
	@NotBlank
	private String mdp;

	public CreateUser(String name, String firstname, String email, String mdp) {
		this.name = name;
		this.firstname = firstname;
		this.email = email;
		this.mdp = mdp;
	}

	public String getName() {
		return name;
	}

	public String getFirstname() {
		return firstname;
	}

	public String getEmail(){
		return email;
	}

	public String getMdp(){
		return mdp;
	}

}
