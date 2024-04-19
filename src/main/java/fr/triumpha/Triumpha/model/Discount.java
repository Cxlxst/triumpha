package fr.triumpha.Triumpha.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Discount {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String uuid;

    private String title;

    private Integer amount;

    public Discount(){}
    public Discount(String title, Integer amount){
        this.title = title;
        this.amount = amount;
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

    public Integer getAmount(){
        return amount;
    }
    public void setAmount(Integer amount){
        this.amount = amount;
    }
}
