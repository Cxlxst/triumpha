package fr.triumpha.Triumpha.model;

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
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String uuid;

    private String title;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "event_id")
    private Event event;

    public Reservation(){}
    public Reservation(String title){
        this.title = title;
    }

    public String getTitle(){
        return title;
    }
    public void setTitle(String title){
        this.title = title;
    }
}
