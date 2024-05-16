package fr.triumpha.Triumpha.model;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

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

    private String email;

    private String mdp;

    private LocalDateTime deletedAt = null;

    private Date createdAt = new Date();

    @OneToMany(mappedBy = "user")
    @JsonIgnore //On empêche ici la sérialisation des listes de réservations
    private List<Reservation> reservations;

    public User() {}
	public User(String name, String firstname, String email, String mdp) {
		this.name = name;
		this.firstname = firstname;
        this.email = email;
        this.mdp = mdp;
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

    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    public String getMdp() {
        return mdp;
    }
    public void setMdp(String mdp) {
        this.mdp = mdp;
    }

    public LocalDateTime getDeletedAt() {
		return deletedAt;
	}
    public void setDeletedAt(LocalDateTime deletedAt) {
		this.deletedAt = deletedAt;
	}

    public Date getCreatedAt() {
		return createdAt;
	}

    public List<Reservation> getReservation(){
        return reservations;
    }
    
}
