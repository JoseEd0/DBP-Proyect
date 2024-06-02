package org.alerta.aplication;

import org.alerta.domain.Alerta;
import org.alerta.domain.AlertaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path="")
public class AlertaController {
    @Autowired
    private AlertaService alertaService;

    @GetMapping
    public ResponseEntity<List<Alerta>> obtenerTodasLasAlertas() {
        List<Alerta> alertaList = alertaService.obtenerTodasLasAlertas();
        return new ResponseEntity<>(alertaList, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Alerta> obtenerAlertaPorId(@PathVariable Long id) {
        Optional<Alerta> alerta = alertaService.obtenerAlertaPorId(id);
        return alerta.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<Alerta> guardarAlerta(@RequestBody Alerta alerta) {
        Alerta savedAlerta = alertaService.guardarAlerta(alerta);
        return new ResponseEntity<>(savedAlerta, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Alerta> actualizarAlerta(@PathVariable Long id, @RequestBody Alerta alerta) {
        Alerta updatedAlerta = alertaService.actualizarAlerta(id, alerta);
        return new ResponseEntity<>(updatedAlerta, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarAlertaPorId (@PathVariable Long id){
        alertaService.eliminarAlertaPorId(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}