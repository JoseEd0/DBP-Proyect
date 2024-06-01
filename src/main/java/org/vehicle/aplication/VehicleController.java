package org.vehicle.aplication;

import org.vehicle.domain.Vehicle;
import org.vehicle.domain.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/vehicles")
public class VehicleController {
    private final VehicleService vehicleService;
    //
    @Autowired
    public VehicleController(VehicleService vehicleService) {
        this.vehicleService = vehicleService;
    }

    @GetMapping
    public ResponseEntity<List<Vehicle>> obtenerTodosLosVehiculos() {
        List<Vehicle> vehicles = vehicleService.obtenerTodosLosVehiculos();
        return ResponseEntity.ok(vehicles);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Vehicle> obtenerVehiculoPorId(@PathVariable Long id) {
        Optional<Vehicle> vehicle = vehicleService.obtenerVehiculoPorId(id);
        return vehicle.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Vehicle> guardarVehiculo(@RequestBody Vehicle vehicle) {
        Vehicle savedVehicle = vehicleService.guardarVehiculo(vehicle);
        return ResponseEntity.ok(savedVehicle);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Vehicle> actualizarVehiculo(@PathVariable Long id, @RequestBody Vehicle vehicle) {
        Vehicle updatedVehicle = vehicleService.actualizarVehiculo(id, vehicle);
        return ResponseEntity.ok(updatedVehicle);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarVehiculoPorId(@PathVariable Long id) {
        vehicleService.eliminarVehiculoPorId(id);
        return ResponseEntity.noContent().build();
    }

}