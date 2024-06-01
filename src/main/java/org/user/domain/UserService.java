package org.user.domain;

import org.user.infraestructure.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

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

    public List<User> findBySex(Sex sex) {
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
}

