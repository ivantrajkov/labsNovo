//package mk.finki.ukim.wp.lab.repository;
//import mk.finki.ukim.wp.lab.model.Event;
//import mk.finki.ukim.wp.lab.model.Location;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Repository;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Optional;
//import java.util.Random;
//import java.util.stream.Collectors;
//
//@Repository
//public class EventRepository {
//    private List<Event> events;
//    private LocationRepository locationRepository;
//
//    public EventRepository(LocationRepository locationRepository) {
//        this.locationRepository = locationRepository;
//        events = new ArrayList<>();
//        initializeEvents();
//    }
//
//    private void initializeEvents() {
//        List<Location> locations = locationRepository.findAll(); // Get all locations
//
//        Random random = new Random();
//        this.events.add(new Event("Tech Conference", "An annual conference on emerging technology trends.", 90, locations.get(random.nextInt(locations.size()))));
//        this.events.add(new Event("Art Exhibition", "Showcasing contemporary art from local artists.", 75, locations.get(random.nextInt(locations.size()))));
//        this.events.add(new Event("Book Fair", "A fair featuring authors and book signings.", 70, locations.get(random.nextInt(locations.size()))));
//        this.events.add(new Event("Charity Run", "A fun run to raise money for local charities.", 80, locations.get(random.nextInt(locations.size()))));
//        this.events.add(new Event("Food Festival", "A festival celebrating international cuisines and culinary arts.", 95, locations.get(random.nextInt(locations.size()))));
//        this.events.add(new Event("Film Festival", "A week-long festival featuring independent films.", 88, locations.get(random.nextInt(locations.size()))));
//        this.events.add(new Event("Science Fair", "A fair for students to showcase their science projects.", 60, locations.get(random.nextInt(locations.size()))));
//        this.events.add(new Event("Job Fair", "Connecting job seekers with potential employers.", 65, locations.get(random.nextInt(locations.size()))));
//        this.events.add(new Event("Startup Pitch", "An event where startups present their business ideas.", 92, locations.get(random.nextInt(locations.size()))));
//        this.events.add(new Event("Music Concert", "A lively music concert featuring popular bands.", 85, locations.get(random.nextInt(locations.size()))));
//        events.forEach(e -> System.out.println(e.getLocation()));
//    }
//
//    public void addEvent(String name, String description, double popularityScore, Location location) {
//        events.add( new Event(name,description,popularityScore,location));
//    }
//
//
//    public List<Event> findAll() {
//        return events;
//    }
//
//    public List<Event> searchEvents(String text) {
//        return events.stream()
//                .filter(event -> event.getName().toLowerCase().contains(text.toLowerCase())
//                        || event.getDescription().toLowerCase().contains(text.toLowerCase()))
//                .collect(Collectors.toList());
//    }
//
//    public Optional<Event> getById(Long id) {
//        return events.stream()
//                .filter(e -> e.getId().equals(id)).findFirst();
//    }
//
//    public List<Event> filterEvents(String rating, String search, List<Event> events) {
//        List<Event> filteredEvents = new ArrayList<>();
//        boolean isFound = false;
//
//        if (rating != null && !rating.isEmpty()) {
//            double ratingDouble = Double.parseDouble(rating);
//            for (Event event : events) {
//                if (event.getPopularityScore() >= ratingDouble) {
//                    if (!filteredEvents.contains(event)) {
//                        filteredEvents.add(event);
//                        isFound = true;
//                    }
//                }
//            }
//        }
//        if (search != null && !search.isEmpty()) {
//            filteredEvents = searchEvents(search);
//            if (isFound) {
//                double ratingDouble = Double.parseDouble(rating);
//                filteredEvents = filteredEvents.stream()
//                        .filter(e -> e.getPopularityScore() >= ratingDouble)
//                        .collect(Collectors.toList());
//            }
//            isFound = true;
//        }
//        return isFound ? filteredEvents : events;
//    }
//
//    public void updateEvent(Long eventId, String name, String description, Double popularityScore, Long locationId) {
//        Optional<Event> eventOpt = getById(eventId);
//        if(!eventOpt.isEmpty()){
//            Optional<Location> locationOpt = locationRepository.getById(locationId);
//            Location location = locationOpt.get();
//            Event event = eventOpt.get();
//            event.setName(name);
//            event.setDescription(description);
//            event.setPopularityScore(popularityScore);
//            event.setLocation(location);
//        }
//    }
//    public void deleteEventById(Long id){
//        events.removeIf(e -> e.getId().equals(id));
//    }
//}
