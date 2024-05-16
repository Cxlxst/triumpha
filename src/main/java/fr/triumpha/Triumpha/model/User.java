package fr.triumpha.Triumpha.model;

import fr.triumpha.Triumpha.constants.Role;
import java.time.LocalDateTime;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.fasterxml.jackson.annotation.JsonInclude;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

import java.util.*;

@Entity
public class User implements UserDetails {

    @Id
	@GeneratedValue(strategy = GenerationType.UUID)
	private String uuid;

    private String name;
	
    private String firstname;

    private String email;

    private String mdp;

    @Enumerated(EnumType.STRING)
	private Role role;

    // // private LocalDateTime deletedAt = null;

    private Date createdAt = new Date();

    @OneToMany(mappedBy = "user")
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

    @Override
    public String getUsername() {
        return email;
    }
    public void setUsername(String email) {
        this.email = email;
    }

    @Override
    public String getPassword() {
        return mdp;
    }
    public void setPassword(String mdp) {
        this.mdp = mdp;
    }

    @Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		Set<Role> roles = Set.of(role);
		List<SimpleGrantedAuthority> authorities = new ArrayList<>();

		for (Role role : roles) {
			authorities.add(new SimpleGrantedAuthority(role.name()));
		}
		return authorities;
	}
    
    public Role getRole() {
        return role;
    }
    public void setRole(Role role) {
        this.role = role;
    }
/* 
    public LocalDateTime getDeletedAt() {
		return deletedAt;
	}
    public void setDeletedAt(LocalDateTime deletedAt) {
		this.deletedAt = deletedAt;
	}
*/
//    public Date getCreatedAt() {
//		return createdAt;
//	}

    public List<Reservation> getReservation(String uuid){
        return reservations;
    }
 
    @Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}
}
