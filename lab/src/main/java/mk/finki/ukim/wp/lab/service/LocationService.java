package mk.finki.ukim.wp.lab.service;

import mk.finki.ukim.wp.lab.model.Location;

import java.util.List;
import java.util.Optional;


public interface LocationService {
    List<Location> findAll();
    Optional<Location> getById(Long id);
    void saveLocation(String name, String address, String capacity, String description);
}
