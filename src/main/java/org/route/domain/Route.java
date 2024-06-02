package org.route.domain;

import jakarta.persistence.*;
import lombok.Data;
import org.alerta.domain.Alerta;
import org.coordinate.domain.Coordinate;

@Data
@Entity
public class Route {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Double distance;

    private String originName;

    private String destinationName;

    @OneToOne(cascade = CascadeType.ALL)
    private Coordinate originCoordinate;

    @OneToOne(cascade = CascadeType.ALL)
    private Coordinate destinationCoordinate;

    private Double burnedCalories;

    @ManyToOne
    private Alerta alerta;

    public Route() {}

    public Route(Double distance, String originName, String destinationName, Coordinate originCoordinate, Coordinate destinationCoordinate, Double burnedCalories, Alerta alerta) {
        this.distance = distance;
        this.originName = originName;
        this.destinationName = destinationName;
        this.originCoordinate = originCoordinate;
        this.destinationCoordinate = destinationCoordinate;
        this.burnedCalories = burnedCalories;
        this.alerta = alerta;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getDistance() {
        return distance;
    }

    public void setDistance(Double distance) {
        this.distance = distance;
    }

    public String getOriginName() {
        return originName;
    }

    public void setOriginName(String originName) {
        this.originName = originName;
    }

    public String getDestinationName() {
        return destinationName;
    }

    public void setDestinationName(String destinationName) {
        this.destinationName = destinationName;
    }

    public Coordinate getOriginCoordinate() {
        return originCoordinate;
    }

    public void setOriginCoordinate(Coordinate originCoordinate) {
        this.originCoordinate = originCoordinate;
    }

    public Coordinate getDestinationCoordinate() {
        return destinationCoordinate;
    }

    public void setDestinationCoordinate(Coordinate destinationCoordinate) {
        this.destinationCoordinate = destinationCoordinate;
    }

    public Double getBurnedCalories() {
        return burnedCalories;
    }

    public void setBurnedCalories(Double burnedCalories) {
        this.burnedCalories = burnedCalories;
    }

    public Alerta getAlert() {
        return alerta;
    }

    public void setAlert(Alerta alerta) {
        this.alerta = alerta;
    }
}