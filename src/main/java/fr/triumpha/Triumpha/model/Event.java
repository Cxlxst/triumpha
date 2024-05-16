package fr.triumpha.Triumpha.model;

import java.sql.Date;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String uuid;

    private String title;

    private String description;

    private Date eventDate;

    private LocalTime startHour;

    private LocalTime endHour;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private CategoryEvent category;

    @ManyToOne
    @JoinColumn(name = "location_id")
    private Location location;

    @OneToMany(mappedBy = "event")
    @JsonIgnore //On empêche ici la sérialisation des listes de réservations
    private List<Reservation> reservations;

    public Event(){}
    public Event(String title, String description, Date eventDate, LocalTime startHour, LocalTime endHour){
        this.title = title;
        this.description = description;
        this.eventDate = eventDate;
        this.startHour = startHour;
        this.endHour = endHour;
    }

    public String getUuid(){
        return uuid;
    }

    public String getTitle(){
        return title;
    }
    public void setTitle(String title){
        this.title = title;
    }

    public String getDescription(){
        return description;
    }
    public void setDescription(String description){
        this.description = description;
    }

    public Date getEventDate(){
        return eventDate;
    }
    public void setEventDate(Date evenDate){
        this.eventDate = evenDate;
    }

    public LocalTime getStartHour(){
        return startHour;
    }
    public void setStartHour(LocalTime startHour){
        this.startHour = startHour;
    }

    public LocalTime getEndHour(){
        return endHour;
    }
    public void setEndHour(LocalTime endHour){
        this.endHour = endHour;
    }

    public CategoryEvent getCategory(){
        return category;
    }
    public void setCategory(CategoryEvent category) {
        this.category = category;
    }

    public Location getLocation(){
        return location;
    }
    public void setLocation(Location location) {
        this.location = location;
    }

    public List<Reservation> getReservation(){
        return reservations;
    }
}
