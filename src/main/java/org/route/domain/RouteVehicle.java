    package org.route.domain;

    import jakarta.persistence.*;
    import lombok.Data;
    import org.vehicle.domain.Vehicle;

    import java.time.LocalTime;
    import java.util.List;


    @Data
    @Entity
    public class RouteVehicle {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;
        private Double duration;
        private Integer caloriesBurned;
        private Long timeStart;
        private Long timeEnd;

        @JoinColumn(name = "vehicle_id")
        @OneToMany
        private Vehicle vehicle;

        @JoinColumn(name = "route_id")
        @OneToMany
        private Route route;

        public RouteVehicle() {}


        // Constructor con valores iniciales
        public RouteVehicle(Double tiempo, Double velocidad, Long idRuta, Long idActividad) {
            this.tiempo = tiempo;
            this.velocidad = velocidad;
            this.idRuta = idRuta;
            this.idActividad = idActividad;
        }

        // Getters y Setters

        public Long getIdHistorial() {
            return idRouteVehicle;
        }

        public void setIdHistorial(Long idHistorial) {
            this.idRouteVehicle = idHistorial;
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
