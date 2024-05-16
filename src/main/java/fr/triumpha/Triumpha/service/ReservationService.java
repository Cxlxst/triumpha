package fr.triumpha.Triumpha.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

import fr.triumpha.Triumpha.dto.CreateReservation;
import fr.triumpha.Triumpha.model.Event;
import fr.triumpha.Triumpha.model.Reservation;
import fr.triumpha.Triumpha.model.User;
import fr.triumpha.Triumpha.repository.EventRepository;
import fr.triumpha.Triumpha.repository.ReservationRepository;
import fr.triumpha.Triumpha.repository.UserRepository;

@Service
public class ReservationService {
    
    private final ReservationRepository reservationRepository;
	private final EventRepository eventRepository;
	private final UserRepository userRepository;


	@Autowired
    public ReservationService(ReservationRepository reservationRepository, EventRepository eventRepository, UserRepository userRepository ) {
        this.reservationRepository = reservationRepository;
        this.eventRepository = eventRepository;
		this.userRepository = userRepository;
    }

	public List<Reservation> findAllEvents() {
		return reservationRepository.findAll();
	}


	public Reservation create(String title, String eventUuid, String userUuid) {

		Event event = eventRepository.findOneByUuid(eventUuid).orElse(null);
		User user = userRepository.findOneByUuid(userUuid).orElse(null);
		

		Reservation reservationACreer = new Reservation(
			title,
			event, 
			user
		);

		System.err.println(reservationACreer);
		
		return reservationRepository.save(reservationACreer);
	}



}
