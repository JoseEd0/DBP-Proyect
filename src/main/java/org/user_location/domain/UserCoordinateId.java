package org.user_location.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
@Getter
@Setter
public class UserCoordinateId implements Serializable {

    @Column(name = "user_id")
    private Long userId;

    @Column(name = "coordinate_id")
    private Long coordinateId;

    public UserCoordinateId() {}

    public UserCoordinateId(Long userId, Long coordinateId) {
        this.userId = userId;
        this.coordinateId = coordinateId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        UserCoordinateId that = (UserCoordinateId) o;

        return Objects.equals(userId, that.userId) &&
                Objects.equals(coordinateId, that.coordinateId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, coordinateId);
    }
}
