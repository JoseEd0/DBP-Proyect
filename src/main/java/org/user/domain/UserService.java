package org.user.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.user.infraestructure.UserRepository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public User save(User user) {
        return userRepository.save(user);
    }

    public User findById(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    public void deleteById(Long id) {
        userRepository.deleteById(id);
    }

    public List<User> findByBirthDateBetween(Date startDate, Date endDate) {
        return userRepository.findByBirthDateBetween(startDate, endDate);
    }

    public List<User> findBySex(User.Sex sex) {
        return userRepository.findBySex(sex);
    }

    public List<User> findByWeightBetween(Double minWeight, Double maxWeight) {
        return userRepository.findByWeightBetween(minWeight, maxWeight);
    }

    public List<User> findByHeightBetween(Double minHeight, Double maxHeight) {
        return userRepository.findByHeightBetween(minHeight, maxHeight);
    }

    public List<User> findByTotalBurnedCaloriesGreaterThan(Double calories) {
        return userRepository.findByTotalBurnedCaloriesGreaterThan(calories);
    }

    // Añadimos los nuevos métodos aquí
    public Optional<User> findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    public boolean existsByEmail(String email) {
        return userRepository.existsByEmail(email);
    }

    public User.Role getRole(String email) {
        User user = userRepository.findByEmail(email).orElse(null);
        return user != null ? user.getRole() : null;
    }
}