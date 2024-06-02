package org.user_location.domain;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.coordinate.domain.Coordinate;
import org.user.domain.User;

@Entity
@Data
@EqualsAndHashCode
public class UserLocation {
    @EmbeddedId
    private UserCoordinateId id;
    public UserLocation(User user, Coordinate coordinate, String description) {
        this.user =  user;
        this.coordinate = coordinate;
        this.description = description;
        this.id = new UserCoordinateId(user.getId(), coordinate.getId());
    }

    public UserLocation() {}

    @Column(nullable = false)
    private String description;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("userId")
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("coordinateId")
    private Coordinate coordinate;

}