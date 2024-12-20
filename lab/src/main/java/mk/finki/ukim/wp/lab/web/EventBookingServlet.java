//package mk.finki.ukim.wp.lab.web;
//
//import jakarta.servlet.ServletException;
//import jakarta.servlet.annotation.WebServlet;
//import jakarta.servlet.http.HttpServlet;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//import mk.finki.ukim.wp.lab.service.EventBookingService;
//import mk.finki.ukim.wp.lab.model.EventBooking;
//import org.thymeleaf.context.WebContext;
//import org.thymeleaf.spring6.SpringTemplateEngine;
//import org.thymeleaf.web.IWebExchange;
//import org.thymeleaf.web.servlet.JakartaServletWebApplication;
//
//import java.io.IOException;
//
//@WebServlet(name = "EventBookingServlet", urlPatterns = "/eventBooking")
//public class EventBookingServlet extends HttpServlet {
//
//    private final EventBookingService eventBooking;
//    private final SpringTemplateEngine springTemplateEngine;
//
//    public EventBookingServlet(EventBookingService eventBooking, SpringTemplateEngine springTemplateEngine) {
//        this.eventBooking = eventBooking;
//        this.Engine = springTemplateEngine;
//    }
//
//    @Override
//    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        IWebExchange webExchange = JakartaServletWebApplication
//                .buildApplication(getServletContext())
//                .buildExchange(req,resp);
////        String eventName = getServletContext().getAttribute("eventName").toString();
////        Integer numTicket = (Integer) req.getServletContext().getAttribute("numTicket");
////        String user = (String) req.getServletContext().getAttribute("user");
//        String user = (String) req.getSession().getAttribute("user");
//        String eventName = (String) req.getSession().getAttribute("eventName");
//        Integer numTicket = (Integer) req.getSession().getAttribute("numTicket");
//        String ipAddress = req.getRemoteAddr();
//        WebContext context = new WebContext(webExchange);
//
//        context.setVariable("eventName",eventName);
//        context.setVariable("numTicket",numTicket);
//        context.setVariable("user",user);
//        context.setVariable("ip",ipAddress);
//
//        EventBooking event = eventBooking.placeBooking(eventName,user,ipAddress,numTicket);
//
//        springTemplateEngine.process("bookingConfirmation.html",context,resp.getWriter());
//    }
//}
