package org.vehicle.domain;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.vehicle.infrastructure.VehicleRepository;

import java.util.List;
import java.util.Optional;

@Service
public class VehicleService {

    private final VehicleRepository vehicleRepository;

    @Autowired
    public VehicleService(VehicleRepository vehicleRepository) {
        this.vehicleRepository = vehicleRepository;
    }

    public List<Vehicle> obtenerTodosLosVehiculos() {
        return vehicleRepository.findAll();
    }

    public Optional<Vehicle> obtenerVehiculoPorId(Long id) {
        return vehicleRepository.findById(id);
    }

    public Vehicle guardarVehiculo(Vehicle vehicle) {
        return vehicleRepository.save(vehicle);
    }

    public Vehicle actualizarVehiculo(Long id, Vehicle vehicle) {
        vehicle.setIdTransporte(id);
        return vehicleRepository.save(vehicle);
    }

    public void eliminarVehiculoPorId(Long id) {
        vehicleRepository.deleteById(id);
    }
}