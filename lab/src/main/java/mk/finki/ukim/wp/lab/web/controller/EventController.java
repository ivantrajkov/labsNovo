package mk.finki.ukim.wp.lab.web.controller;

import mk.finki.ukim.wp.lab.model.Event;
import mk.finki.ukim.wp.lab.model.Location;
import mk.finki.ukim.wp.lab.service.EventService;
import mk.finki.ukim.wp.lab.service.LocationService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/events")
public class EventController {
    private final EventService eventService;
    private final LocationService locationService;

    public EventController(EventService eventService, LocationService locationService) {
        this.eventService = eventService;
        this.locationService = locationService;
    }

    @GetMapping
    public String getEventsPage(
            @RequestParam(required = false) String error,
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String popularity,
            @RequestParam(required = false) String location,
            Model model){
        List<Event> events = eventService.listAll();
        if(error == null){
            error = "";
        }
        if(name == null){
            name = "";
        }
        if(popularity == null){
            popularity = "";
        }
        if(!name.isBlank() || !popularity.isBlank()){
            events = eventService.filterEvents(popularity,name);
        }
        if(location != null){
            events = eventService.findByLocation_NameContainsIgnoreCase(location);
        }
        model.addAttribute("events",events);
        if(error != null && !error.isEmpty()){
            model.addAttribute("hasError",true);
            model.addAttribute("error",error);
        }
        return "listEvents";
    }

    @PostMapping("/add")
    public String saveEvent(
            @RequestParam String name,
            @RequestParam String description,
            @RequestParam double popularityScore,
            @RequestParam long id)
    {
        Optional<Location> locationOpt = locationService.getById(id);
        Location location = null;
        if(locationOpt.isPresent()) {
            location = locationOpt.get();
        }
        eventService.addEvent(name,description,popularityScore,location);
        return "redirect:/events";
    }

    @PostMapping("/edit/{eventId}")
    public String editEvent(
            @PathVariable Long eventId,
            @RequestParam String name,
            @RequestParam String description,
            @RequestParam double popularityScore,
            @RequestParam long locationId) {
        eventService.updateEvent(eventId, name, description, popularityScore, locationId);
        return "redirect:/events";
    }

    @GetMapping("/delete/{id}")
    public String deleteEvent(@PathVariable Long id){
        this.eventService.deleteEventById(id);
        return "redirect:/events";
    }
    @GetMapping("/edit-form/{id}")
    public String getEditEventForm(@PathVariable Long id,  Model model, @RequestParam(required = false)String error){
        Optional<Event> event = eventService.getEventById(id);

        if (event.isEmpty()) {
            return "redirect:/events?error=EventNotFound";
        }
        List<Location> locations = locationService.findAll();
        model.addAttribute("event", event.get());
        model.addAttribute("locations", locations);
        return "edit-event";
    }
    @GetMapping("/add-form")
    public String getAddEventPage(Model model){
        List<Location> locations = locationService.findAll();
        model.addAttribute("event",null);
        model.addAttribute("locations",locations);
        return "add-event";
    }

}
