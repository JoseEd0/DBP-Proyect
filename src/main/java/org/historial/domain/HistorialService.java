package org.historial.domain;

import org.historial.infraestructure.HistorialRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HistorialService {

    private final HistorialRepository historialRepository;

    @Autowired
    public HistorialService(HistorialRepository historialRepository) {
        this.historialRepository = historialRepository;
    }

    public List<Historial> obtenerTodosLosHistoriales() {
        return historialRepository.findAll();
    }

    public Optional<Historial> obtenerHistorialPorId(Long id) {
        return historialRepository.findById(id);
    }

    public Historial guardarHistorial(Historial historial) {
        return historialRepository.save(historial);
    }

    public Historial actualizarHistorial(Long id, Historial historial) {
        historial.setIdHistorial(id);
        return historialRepository.save(historial);
    }

    public void eliminarHistorialPorId(Long id) {
        historialRepository.deleteById(id);
    }
}