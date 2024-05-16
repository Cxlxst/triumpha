package fr.triumpha.Triumpha.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import fr.triumpha.Triumpha.model.Event;

@Repository
public interface EventRepository extends JpaRepository<Event, String>{

	List<Event> findAll();

    Optional<Event> findOneByUuid(String uuid);

    Event save(Event event);
}
