package org.alerta.domain;

import org.alerta.infrastructure.AlertaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AlertaService {

    private final AlertaRepository alertaRepository;

    @Autowired
    public AlertaService(AlertaRepository alertaRepository) {
        this.alertaRepository = alertaRepository;
    }

    public List<Alerta> obtenerTodasLasAlertas() {
        return alertaRepository.findAll();
    }

    public Optional<Alerta> obtenerAlertaPorId(Long id) {
        return alertaRepository.findById(id);
    }

    public Alerta guardarAlerta(Alerta alerta) {
        return alertaRepository.save(alerta);
    }

    public Alerta actualizarAlerta(Long id, Alerta alerta) {
        alerta.setId(id);
        return alertaRepository.save(alerta);
    }

    public void eliminarAlertaPorId(Long id) {
        alertaRepository.deleteById(id);
    }
}