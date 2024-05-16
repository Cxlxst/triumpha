package fr.triumpha.Triumpha.dto;

import fr.triumpha.Triumpha.model.Event;
import fr.triumpha.Triumpha.model.User;
import jakarta.validation.constraints.NotBlank;

public class CreateReservation {
    
    @NotBlank
	private String title;

	private User user;

	private Event event;



	public CreateReservation(String title, User user, Event event) {
		this.title = title;
		this.user = user;
		this.event = event;
	}



	public String getTitle() {
		return title;
	}

	public User getDescription() {
		return user;
	}

	public Event getEventDate() {
		return event;
	}



}
