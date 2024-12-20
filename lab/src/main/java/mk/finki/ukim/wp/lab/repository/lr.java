//package mk.finki.ukim.wp.lab.repository;
//
//import mk.finki.ukim.wp.lab.model.Location;
//import org.springframework.stereotype.Repository;
//import java.util.*;
//
//@Repository
//public class LocationRepository {
//    private List<Location> locations;
//
//    public LocationRepository() {
//        this.locations = new ArrayList<>();
//        locations.add(new Location("Central Park", "New York, NY", "500", "A large public park"));
//        locations.add(new Location("Eiffel Tower", "Paris, France", "1000", "An iconic landmark"));
//        locations.add(new Location("Great Wall of China", "Beijing, China", "2000", "Ancient fortification"));
//        locations.add(new Location("Colosseum", "Rome, Italy", "1500", "An ancient amphitheater"));
//        locations.add(new Location("Sydney Opera House", "Sydney, Australia", "500", "A famous performing arts center"));
//    }
//    public List<Location> findAll(){
//        return locations;
//    }
//    public Optional<Location> getById(Long id){
//        return locations.stream().filter(l -> l.getId().equals(id)).findFirst();
//    }
//}
