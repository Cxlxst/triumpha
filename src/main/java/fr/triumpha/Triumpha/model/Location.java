package fr.triumpha.Triumpha.model;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Location {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String uuid;

    private String title;

    private String country;

    private String city;

    private String adress;

    private Integer zipCode;

    @OneToMany(mappedBy = "location")
    private List<Event> events;

    public Location(){}
    public Location(String title, String country, String city, String adress, Integer zipCode){
        this.title = title;
        this.country = country;
        this.city = city;
        this.adress = adress;
        this.zipCode = zipCode;
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

    public String getCountry(){
        return country;
    }
    public void setCountry(String country){
        this.country = country;
    }

    public String getCity() {
        return city;
    }
    public void setCity(String city) {
        this.city = city;
    }

    public String getAdress() {
        return adress;
    }
    public void setAdress(String adress) {
        this.adress = adress;
    }

    public Integer getZipCode() {
        return zipCode;
    }
    public void setZipCode(Integer zipCode) {
        this.zipCode = zipCode;
    }
    
    public List<Event> getEvents() {
        return events;
    }
}
