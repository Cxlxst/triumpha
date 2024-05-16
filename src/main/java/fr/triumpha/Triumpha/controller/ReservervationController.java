package fr.triumpha.Triumpha.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import java.util.Map;


import fr.triumpha.Triumpha.dto.CreateReservation;
import fr.triumpha.Triumpha.model.Reservation;
import fr.triumpha.Triumpha.model.User;
import fr.triumpha.Triumpha.service.ReservationService;
import jakarta.validation.Valid;


@RestController
@RequestMapping("/reservation")
public class ReservervationController {
    
    private final ReservationService service;

	@Autowired
	public ReservervationController(ReservationService service) {
		this.service = service;
	}

	@GetMapping
	public ResponseEntity<List<Reservation>> findAll() {;
		return new ResponseEntity<>(service.findAllEvents(), HttpStatus.OK);
	}

	@PostMapping
    public ResponseEntity<Reservation> save(@RequestBody Map<String, Object> json) {
        String eventUuid = (String) json.get("eventUUID");
        String userUuid = (String) json.get("userUUID");
		String title = (String) json.get("title");
        System.out.println("UUID de l'événement : " + eventUuid);
        System.out.println("UUID de l'utilisateur : " + userUuid);
		System.out.println("Title : " + title);  

		Reservation reservationUser = service.create(title, eventUuid, userUuid);
		return new ResponseEntity<>(reservationUser, HttpStatus.CREATED);
    }

}
