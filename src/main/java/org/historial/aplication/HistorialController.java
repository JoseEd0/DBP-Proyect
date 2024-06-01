package org.historial.aplication;

import org.historial.domain.Historial;
import org.historial.domain.HistorialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path="")
public class HistorialController {
    @Autowired
    private HistorialService historialService;

    @GetMapping
    public ResponseEntity<List<Historial>> obtenerTodosLosHistoriales() {
        List<Historial> historialList = historialService.obtenerTodosLosHistoriales();
        return new ResponseEntity<>(historialList, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Historial> obtenerHistorialPorId(@PathVariable Long id) {
        Optional<Historial> historial = historialService.obtenerHistorialPorId(id);
        return historial.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<Historial> guardarHistorial(@RequestBody Historial historial) {
        Historial savedHistorial = historialService.guardarHistorial(historial);
        return new ResponseEntity<>(savedHistorial, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Historial> actualizarHistorial(@PathVariable Long id, @RequestBody Historial historial) {
        Historial updatedHistorial = historialService.actualizarHistorial(id, historial);
        return new ResponseEntity<>(updatedHistorial, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarHistorialPorId (@PathVariable Long id){
        historialService.eliminarHistorialPorId(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}