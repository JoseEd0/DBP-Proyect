package org.historial.domain;

import jakarta.persistence.*;
import lombok.Data;
import org.actividadFisica.domain.ActividadFisica;
import org.route.domain.Route;

import java.util.List;

@Data
@Entity
public class Historial {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idHistorial;
    private Double tiempo;
    private Double velocidad;
    private Long idRuta;
    private Long idActividad;

    @ManyToOne
    private Route ruta;
    // Constructor por defecto
    public Historial() {}
    @OneToMany(mappedBy = "historial", cascade = CascadeType.ALL)
    private List<ActividadFisica> actividadFisica;

    // Constructor con valores iniciales
    public Historial(Double tiempo, Double velocidad, Long idRuta, Long idActividad) {
        this.tiempo = tiempo;
        this.velocidad = velocidad;
        this.idRuta = idRuta;
        this.idActividad = idActividad;
    }

    // Getters y Setters

    public Long getIdHistorial() {
        return idHistorial;
    }

    public void setIdHistorial(Long idHistorial) {
        this.idHistorial = idHistorial;
    }

    public Double getTiempo() {
        return tiempo;
    }

    public void setTiempo(Double tiempo) {
        this.tiempo = tiempo;
    }

    public Double getVelocidad() {
        return velocidad;
    }

    public void setVelocidad(Double velocidad) {
        this.velocidad = velocidad;
    }

    public Long getIdRuta() {
        return idRuta;
    }

    public void setIdRuta(Long idRuta) {
        this.idRuta = idRuta;
    }

    public Long getIdActividad() {
        return idActividad;
    }

    public void setIdActividad(Long idActividad) {
        this.idActividad = idActividad;
    }
}