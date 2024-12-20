package mk.finki.ukim.wp.lab.initialization;

import mk.finki.ukim.wp.lab.model.Location;
import mk.finki.ukim.wp.lab.service.EventService;
import mk.finki.ukim.wp.lab.service.LocationService;
import mk.finki.ukim.wp.lab.service.implementation.EventServiceImpl;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer implements CommandLineRunner {

    private final LocationService locationService;
    private final EventService eventService;

    public DataInitializer(LocationService locationService, EventService eventService) {
        this.locationService = locationService;
        this.eventService = eventService;
    }

    @Override
    public void run(String... args) throws Exception {
        if (locationService.findAll().isEmpty()) {
            locationService.saveLocation("Venue A", "123 Main St", "500", "Spacious hall with modern amenities");
            locationService.saveLocation("Conference Center B", "45 Elm St", "300", "Ideal for corporate events");
            locationService.saveLocation("Outdoor Venue C", "Sunny Park", "1000", "Open space with stage and seating");
            eventService.addEvent("TEstiram","test",15.0,locationService.findAll().get(0));
        }
    }
}
