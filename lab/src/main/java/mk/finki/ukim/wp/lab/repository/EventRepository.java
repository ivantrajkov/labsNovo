package mk.finki.ukim.wp.lab.repository;

import mk.finki.ukim.wp.lab.model.Event;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EventRepository extends JpaRepository<Event, Long> {
    List<Event> findAllByLocation_Id(Long locationId);
    List<Event> findByPopularityScoreGreaterThanAndNameContainingIgnoreCase(double rating, String search);
    List<Event> findByNameContainsIgnoreCaseOrAndDescriptionContainsIgnoreCase(String text, String text2);
//    List<Event> findByLocationContainsIgnoreCaseAndDescriptionContainsIgnoreCase(String text, String text2);
    List<Event> findByLocation_NameContainsIgnoreCase(String text);
}
