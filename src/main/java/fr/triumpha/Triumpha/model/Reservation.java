package fr.triumpha.Triumpha.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;

@Entity
// L'user ne peut réserver l'évènement qu'une fois
@Table(
    name = "reservation",
    uniqueConstraints = @UniqueConstraint(columnNames = {"user_id", "event_id"})
)
@JsonIdentityInfo(generator=ObjectIdGenerators.PropertyGenerator.class, property="uuid") //Permet de retourner chaque réservation de manière unique grace à l'uuid qui évite les doublons
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String uuid;

    private String title;

    @ManyToOne
    @JoinColumn(name = "user_id")
    @JsonBackReference
    private User user;

    @ManyToOne
    @JoinColumn(name = "event_id")
    @JsonManagedReference
    private Event event;

    public Reservation(){}
    public Reservation(String title){
        this.title = title;
    }

    public String getUuid() {
		return uuid;
	}

    public String getTitle(){
        return title;
    }
    public void setTitle(String title){
        this.title = title;
    }

    public User getUser() {
        return user;
    }
    public void setUser(User user) {
        this.user = user;
    }

    public Event getEvent() {
        return event;
    }
    public void setEvent(Event event) {
        this.event = event;
    }
}
