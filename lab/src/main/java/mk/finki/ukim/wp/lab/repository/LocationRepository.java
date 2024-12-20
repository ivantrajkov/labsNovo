package mk.finki.ukim.wp.lab.repository;

import jakarta.persistence.Id;
import mk.finki.ukim.wp.lab.model.Location;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.*;

public interface LocationRepository extends JpaRepository<Location, Long> {
    List<Location> findByNameContainsIgnoreCaseOrDescriptionContainsIgnoreCase(String text, String text2);
}
