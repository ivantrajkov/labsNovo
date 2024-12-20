package mk.finki.ukim.wp.lab.web;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import mk.finki.ukim.wp.lab.service.EventService;
import mk.finki.ukim.wp.lab.model.Event;
import org.thymeleaf.context.WebContext;
import org.thymeleaf.spring6.SpringTemplateEngine;
import org.thymeleaf.web.IWebExchange;
import org.thymeleaf.web.servlet.JakartaServletWebApplication;

import java.io.IOException;
import java.util.*;

@WebServlet(name = "EventListServlet",urlPatterns = {"","/servlet/event-list"})
public class EventListServlet extends HttpServlet {

    private final EventService eventService;
    private final SpringTemplateEngine springTemplateEngine;

    public EventListServlet(EventService eventService, SpringTemplateEngine springTemplateEngine) {
        this.eventService = eventService;
        this.springTemplateEngine = springTemplateEngine;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        IWebExchange webExchange = JakartaServletWebApplication
                .buildApplication(getServletContext())
                .buildExchange(req, resp);

        WebContext context = new WebContext(webExchange);

        String search = req.getParameter("filteredWord");
        String rating = req.getParameter("filteredRating");


        List<Event> events = eventService.listAll();

        events = eventService.filterEvents(rating,search);
        context.setVariable("events",events);
        springTemplateEngine.process("listEvents.html",context,resp.getWriter());

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String eventName = req.getParameter("event");
        int numTicket = Integer.parseInt(req.getParameter("numTicket"));
        String user = req.getParameter("user");
        req.getSession().setAttribute("user",user);
        req.getSession().setAttribute("eventName",eventName);
        req.getSession().setAttribute("numTicket",numTicket);

        resp.sendRedirect(req.getContextPath() + "/eventBooking");
    }
}
