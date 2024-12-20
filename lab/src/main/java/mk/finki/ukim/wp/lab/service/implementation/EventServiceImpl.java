package mk.finki.ukim.wp.lab.service.implementation;

import mk.finki.ukim.wp.lab.model.Location;
import mk.finki.ukim.wp.lab.repository.EventRepository;
import mk.finki.ukim.wp.lab.repository.LocationRepository;
import mk.finki.ukim.wp.lab.service.EventService;
import mk.finki.ukim.wp.lab.model.Event;
import mk.finki.ukim.wp.lab.service.LocationService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EventServiceImpl implements EventService {

    private final EventRepository eventRepository;
    private final LocationService locationService;
    private final LocationRepository locationRepository;

    public EventServiceImpl(EventRepository eventRepository, LocationService locationService, LocationRepository locationRepository) {
        this.eventRepository = eventRepository;
        this.locationService = locationService;
        this.locationRepository = locationRepository;
    }

    @Override
    public List<Event> listAll() {
        return eventRepository.findAll();
    }

    @Override
    public List<Event> searchEvents(String text) {
        return eventRepository.findByNameContainsIgnoreCaseOrAndDescriptionContainsIgnoreCase(text,text);
    }

    @Override
    public List<Event> filterEvents(String rating, String search) {
        return eventRepository.findByPopularityScoreGreaterThanAndNameContainingIgnoreCase(Double.parseDouble(rating),search);
//        return eventRepository.filterEvents(rating, search, events);
    }

    @Override
    public Optional<Event> getEventById(long id) {
        return eventRepository.findById(id);
    }

    @Override
    public void updateEvent(Long eventId, String name, String description, Double popularityScore, Long locationId) {
        Optional<Event> eventOpt = eventRepository.findById(eventId);
        Event event;
        if(eventOpt.isPresent()){
            event = eventOpt.get();
            event.setName(name);
            event.setDescription(description);
            event.setPopularityScore(popularityScore);
            Optional<Location> locationOpt = locationRepository.findById(locationId);
            Location location = locationOpt.get();
            event.setLocation(location);
            eventRepository.save(event);
        }
    }

    @Override
    public void deleteEventById(Long id) {
        eventRepository.deleteById(id);
    }

    @Override
    public void addEvent(String name, String description, double popularityScore, Location location) {
        eventRepository.save(new Event(name, description, popularityScore, location));
    }

    @Override
    public List<Event> findByLocation_NameContainsIgnoreCase(String text) {
        return eventRepository.findByLocation_NameContainsIgnoreCase(text);
    }

}


