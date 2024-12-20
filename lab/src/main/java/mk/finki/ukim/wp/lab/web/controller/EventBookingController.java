package mk.finki.ukim.wp.lab.web.controller;

import jakarta.servlet.http.HttpServletRequest;
import mk.finki.ukim.wp.lab.model.Event;
import mk.finki.ukim.wp.lab.model.Location;
import mk.finki.ukim.wp.lab.repository.EventRepository;
import mk.finki.ukim.wp.lab.service.EventBookingService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping("/eventBooking")
public class EventBookingController {

    private final EventBookingService eventBookingService;
    private final EventRepository eventRepository;

    public EventBookingController(EventBookingService eventBookingService, EventRepository eventRepository) {
        this.eventBookingService = eventBookingService;
        this.eventRepository = eventRepository;
    }

    @PostMapping
    public String confirmEvent(
            @RequestParam String user,
            @RequestParam Long eventID,
            @RequestParam Integer numTicket,
            HttpServletRequest request,
            Model model
            )
    {
        String ipAddress = request.getRemoteAddr();
        Optional<Event> eventOpt = Optional.of(eventRepository.getById(eventID));
        Event event = eventOpt.get();
        String eventName = event.getName();
        Location location = event.getLocation();
        String locationName = location.getName();
        eventBookingService.placeBooking(eventName,user,ipAddress,numTicket);
        model.addAttribute("user",user);
        model.addAttribute("eventName", eventName);
        model.addAttribute("numTicket",numTicket);
        model.addAttribute("ipAddress",ipAddress);
        model.addAttribute("location",locationName);
        return "bookingConfirmation";
    }
//    @GetMapping("/confirmation")
//    public String getBookingConfirmation(Model model){
//        model.addAttribute("user",user);
//        model.addAttribute("eventName",eventName);
//        model.addAttribute("numTicket",numTicket);
//        model.addAttribute("ipAddress",ipAddress);
//        return "bookingConfirmation";
//    }
}
