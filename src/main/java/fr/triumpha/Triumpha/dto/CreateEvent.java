package fr.triumpha.Triumpha.dto;

import java.sql.Date;
import java.time.LocalDateTime;
import java.time.LocalTime;

import jakarta.validation.constraints.NotBlank;

public class CreateEvent {
    
    @NotBlank
	private String title;

	@NotBlank
	private String description;

	private Date eventDate;

	private LocalTime startHour;

	private LocalTime endHour;




	public CreateEvent(String title, String description, Date eventDate, LocalTime startHour, LocalTime endHour) {
		this.title = title;
		this.description = description;
		this.eventDate = eventDate;
		this.startHour = startHour;
		this.endHour = endHour;
	}



	public String getTitle() {
		return title;
	}

	public String getDescription() {
		return description;
	}

	public Date getEventDate() {
		return eventDate;
	}

	public LocalTime getStartHour() {
		return startHour;
	}

	public LocalTime getEndHour() {
		return endHour;
	}
	


}
