package org.user.infrastructure;
import org.user.domain.Sex;
import org.user.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    List<User> findByBirthDateBetween(Date startDate, Date endDate);

    List<User> findBySex(Sex sex);

    List<User> findByWeightBetween(Double minWeight, Double maxWeight);

    List<User> findByHeightBetween(Double minHeight, Double maxHeight);

    List<User> findByTotalBurnedCaloriesGreaterThan(Double calories);


    Optional<User> findByEmail(String email);
    boolean existsByEmail(String email);
}