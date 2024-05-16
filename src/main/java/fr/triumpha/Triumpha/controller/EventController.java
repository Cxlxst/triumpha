package fr.triumpha.Triumpha.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.w3c.dom.events.EventTarget;

import java.util.List;

import fr.triumpha.Triumpha.dto.CreateEvent;
import fr.triumpha.Triumpha.dto.CreateUser;
import fr.triumpha.Triumpha.model.Event;
import fr.triumpha.Triumpha.model.User;
import fr.triumpha.Triumpha.service.EventService;
import jakarta.validation.Valid;


@RestController
@RequestMapping("/events")
public class EventController {
    
    private final EventService service;

	@Autowired
	public EventController(EventService service) {
		this.service = service;
	}

	@GetMapping
	public ResponseEntity<List<Event>> findAll() {;
		return new ResponseEntity<>(service.findAllEvents(), HttpStatus.OK);
	}

	@GetMapping("/{uuid}")
	public ResponseEntity<Event> findOneById(@PathVariable String uuid) {
		Event event = service.findUserById(uuid);
		if(event != null) {
			return new ResponseEntity<>(service.findUserById(uuid), HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}


	@PostMapping
	public ResponseEntity<Event> save(@Valid @RequestBody CreateEvent event) {
		Event createdEvent = service.create(event);
		return new ResponseEntity<>(createdEvent, HttpStatus.CREATED);
	}

}
