package fr.triumpha.Triumpha.model;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class CategoryEvent {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String uuid;

    private String title;

    @OneToMany(mappedBy = "category")
    private List<Event> events;

    public CategoryEvent(){}
    public CategoryEvent(String title){
        this.title = title;
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
}
