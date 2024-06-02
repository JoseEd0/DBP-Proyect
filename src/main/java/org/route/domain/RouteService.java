package org.route.domain;

import org.route.infrastructure.RouteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RouteService {

    private final RouteRepository rutaRepository;

    @Autowired
    public RouteService(RouteRepository rutaRepository) {
        this.rutaRepository = rutaRepository;
    }

    public List<Route> obtenerTodasLasRutas() {
        return rutaRepository.findAll();
    }

    public Optional<Route> obtenerRutaPorId(Long id) {
        return rutaRepository.findById(id);
    }

    public Route guardarRuta(Route ruta) {
        return rutaRepository.save(ruta);
    }

    public Route actualizarRuta(Long id, Route ruta) {
        ruta.setId(id);
        return rutaRepository.save(ruta);
    }

    public void eliminarRutaPorId(Long id) {
        rutaRepository.deleteById(id);
    }

}