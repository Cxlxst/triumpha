package fr.triumpha.Triumpha.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

import fr.triumpha.Triumpha.dto.CreateEvent;
import fr.triumpha.Triumpha.model.Event;
import fr.triumpha.Triumpha.repository.EventRepository;

@Service
public class EventService {
    
    private final EventRepository repository;

	@Autowired
	public EventService(EventRepository repository) {
		this.repository = repository;
	}

	public List<Event> findAllEvents() {
		return repository.findAll();
	}


	public Event create(CreateEvent event) {
		// ici je suis dans la DTO
		Event eventACreer = new Event(
			event.getTitle(),
			event.getDescription(),
			event.getEventDate(),
			event.getStartHour(),
			event.getEndHour()
		);
		
		// je suis dans une entité
		return repository.save(eventACreer);
	}



}
