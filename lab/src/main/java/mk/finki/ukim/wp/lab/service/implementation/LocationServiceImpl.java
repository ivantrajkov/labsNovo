package mk.finki.ukim.wp.lab.service.implementation;

import mk.finki.ukim.wp.lab.model.Location;
import mk.finki.ukim.wp.lab.repository.LocationRepository;
import mk.finki.ukim.wp.lab.service.LocationService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LocationServiceImpl implements LocationService {
    private final LocationRepository locationRepository;

    public LocationServiceImpl(LocationRepository locationRepository) {
        this.locationRepository = locationRepository;
    }

    public List<Location> findAll(){
        return locationRepository.findAll();
    }

    @Override
    public Optional<Location> getById(Long id) {
        return locationRepository.findById(id);
    }

    @Override
    public void saveLocation(String name, String address, String capacity, String description) {
        locationRepository.save(new Location(name, address, capacity, description));
    }
}
