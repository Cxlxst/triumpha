package fr.triumpha.Triumpha.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import fr.triumpha.Triumpha.model.Reservation;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation, String>{

	List<Reservation> findAll();

    Reservation save(Reservation reservation);
}
