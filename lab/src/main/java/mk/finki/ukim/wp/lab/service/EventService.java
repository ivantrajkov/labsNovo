package mk.finki.ukim.wp.lab.service;

import mk.finki.ukim.wp.lab.model.Event;
import mk.finki.ukim.wp.lab.model.Location;

import java.util.List;
import java.util.Optional;

public interface EventService {
    List<Event> listAll();
    List<Event> searchEvents(String text);
    List<Event> filterEvents(String rating,String search);
    Optional<Event> getEventById(long id);
    void updateEvent(Long eventId,String name, String description, Double popularityScore, Long locationId);
    void deleteEventById(Long id);
    void addEvent(String name, String description, double popularityScore, Location location);
    List<Event> findByLocation_NameContainsIgnoreCase(String text);
}

