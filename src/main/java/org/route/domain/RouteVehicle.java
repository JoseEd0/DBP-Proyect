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
        @ManyToOne
        private Vehicle vehicle;

        @JoinColumn(name = "route_id")
        @ManyToOne
        private Route route;

        public RouteVehicle() {}


        // Constructor con valores iniciales
        public RouteVehicle(Double duration, Integer caloriesBurned, Long timeStart, Long timeEnd) {
            this.duration = duration;
            this.caloriesBurned = caloriesBurned;
            this.timeStart = timeStart;
            this.timeEnd = timeEnd;
        }

        // Getters y Setters

        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public Double getDuration() {
            return duration;
        }

        public void setDuration(Double duration) {
            this.duration = duration;
        }

        public Integer getCaloriesBurned() {
            return caloriesBurned;
        }

        public void setCaloriesBurned(Integer caloriesBurned) {
            this.caloriesBurned = caloriesBurned;
        }

        public Long getTimeStart() {
            return timeStart;
        }

        public void setTimeStart(Long timeStart) {
            this.timeStart = timeStart;
        }

        public Long getTimeEnd() {
            return timeEnd;
        }

        public void setTimeEnd(Long timeEnd) {
            this.timeEnd = timeEnd;
        }

        public Vehicle getVehicle() {
            return vehicle;
        }

        public void setVehicle(Vehicle vehicle) {
            this.vehicle = vehicle;
        }

        public Route getRoute() {
            return route;
        }

        public void setRoute(Route route) {
            this.route = route;
        }

    }
