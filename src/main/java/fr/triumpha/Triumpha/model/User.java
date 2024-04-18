package fr.triumpha.Triumpha.model;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class User {

    @Id
	@GeneratedValue(strategy = GenerationType.UUID)
	private String uuid;

    @Column(
		length = 25
	)

    private String name;
	
    private String firstname;

    private LocalDateTime deletedAt = null;

   
    public User() {}
	public User(String name, String firstname) {
		this.name = name;
		this.firstname = firstname;
	}

    public String getUuid() {
		return uuid;
	}

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getFirstname() {
        return firstname;
    }
    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public LocalDateTime getDeletedAt() {
		return deletedAt;
	}

	public void setDeletedAt(LocalDateTime deletedAt) {
		this.deletedAt = deletedAt;
	}
    
}
