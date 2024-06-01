package org.coordinate.Aplication;

import org.coordinate.domain.Coordinate;
import org.coordinate.domain.CoordinateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/coordinates")
public class CoordinateController {
    private final CoordinateService coordinateService;

    @Autowired
    public CoordinateController(CoordinateService coordinateService) {
        this.coordinateService = coordinateService;
    }

    @GetMapping
    public ResponseEntity<List<Coordinate>> getAllCoordinates() {
        List<Coordinate> coordinates = coordinateService.getAllCoordinates();
        return ResponseEntity.ok(coordinates);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Coordinate> getCoordinateById(@PathVariable Long id) {
        Optional<Coordinate> coordinate = coordinateService.getCoordinateById(id);
        return coordinate.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Coordinate> createCoordinate(@RequestBody Coordinate coordinate) {
        Coordinate createdCoordinate = coordinateService.saveCoordinate(coordinate);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdCoordinate);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Coordinate> updateCoordinate(@PathVariable Long id, @RequestBody Coordinate coordinate) {
        Optional<Coordinate> existingCoordinate = coordinateService.getCoordinateById(id);
        if (existingCoordinate.isPresent()) {
            Coordinate updatedCoordinate = coordinateService.updateCoordinate(id, coordinate);
            return ResponseEntity.ok(updatedCoordinate);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCoordinate(@PathVariable Long id) {
        Optional<Coordinate> existingCoordinate = coordinateService.getCoordinateById(id);
        if (existingCoordinate.isPresent()) {
            coordinateService.deleteCoordinateById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    @GetMapping("/{id1}/distance/{id2}")
    public ResponseEntity<Double> calculateDistance(@PathVariable Long id1, @PathVariable Long id2) {
        Optional<Coordinate> coordinate1 = coordinateService.getCoordinateById(id1);
        Optional<Coordinate> coordinate2 = coordinateService.getCoordinateById(id2);

        if (coordinate1.isPresent() && coordinate2.isPresent()) {
            double distance = coordinateService.calculateDistance(coordinate1.get(), coordinate2.get());
            return ResponseEntity.ok(distance);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
