package org.coordinate.domain;

import org.coordinate.infrastructure.CoordinateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class CoordinateService {
    private final CoordinateRepository coordinateRepository;

    @Autowired
    public CoordinateService(CoordinateRepository coordinateRepository) {
        this.coordinateRepository = coordinateRepository;
    }

    public List<Coordinate> getAllCoordinates() {
        return coordinateRepository.findAll();
    }

    public Optional<Coordinate> getCoordinateById(Long id) {
        return coordinateRepository.findById(id);
    }

    public Coordinate saveCoordinate(Coordinate coordinate) {
        return coordinateRepository.save(coordinate);
    }

    public Coordinate updateCoordinate(Long id, Coordinate coordinate) {
        coordinate.setId(id);
        return coordinateRepository.save(coordinate);
    }

    public void deleteCoordinateById(Long id) {
        coordinateRepository.deleteById(id);
    }
    public double calculateDistance(Coordinate coord1, Coordinate coord2) {
        double R = 6371; // Radio de la Tierra en kilómetros

        double latDistance = Math.toRadians(coord2.getLatitude() - coord1.getLatitude());
        double lonDistance = Math.toRadians(coord2.getLongitude() - coord1.getLongitude());
        double a = Math.sin(latDistance / 2) * Math.sin(latDistance / 2)
                + Math.cos(Math.toRadians(coord1.getLatitude())) * Math.cos(Math.toRadians(coord2.getLatitude()))
                * Math.sin(lonDistance / 2) * Math.sin(lonDistance / 2);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
        double distance = R * c;

        return distance;
    }

}
