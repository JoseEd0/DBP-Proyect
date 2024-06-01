package org.coordinate.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.user_location.domain.UserLocation;

import java.util.ArrayList;
import java.util.List;
@Entity
@Getter
@Setter
public class Coordinate {

    public Coordinate(Double latitude, Double longitude) {
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public Coordinate() {}

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Double latitude;

    @Column(nullable = false)
    private Double longitude;


    @OneToMany(mappedBy = "coordinate",
            orphanRemoval = true
    )
    private List<UserLocation> users = new ArrayList<>();

}