package org.user.aplication;

import org.user.domain.Sex;
import org.user.domain.User;
import org.user.domain.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping
    public List<User> getAllUsers() {
        return userService.findAll();
    }

    @GetMapping("/{id}")
    public User getUserById(@PathVariable Long id) {
        return userService.findById(id);
    }

    @PostMapping
    public User createUser(@RequestBody User user) {
        return userService.save(user);
    }

    @PutMapping("/{id}")
    public User updateUser(@PathVariable Long id, @RequestBody User user) {
        user.setIdUser(id); // Aseguramos que el ID del usuario sea el correcto
        return userService.save(user);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id) {
        userService.deleteById(id);
    }

    @GetMapping("/birthDateBetween")
    public List<User> getUsersByBirthDateBetween(@RequestParam("startDate") Date startDate, @RequestParam("endDate") Date endDate) {
        return userService.findByBirthDateBetween(startDate, endDate);
    }

    @GetMapping("/bySex")
    public List<User> getUsersBySex(@RequestParam("sex") Sex sex) {
        return userService.findBySex(sex);
    }

    @GetMapping("/weightBetween")
    public List<User> getUsersByWeightBetween(@RequestParam("minWeight") Double minWeight, @RequestParam("maxWeight") Double maxWeight) {
        return userService.findByWeightBetween(minWeight, maxWeight);
    }

    @GetMapping("/heightBetween")
    public List<User> getUsersByHeightBetween(@RequestParam("minHeight") Double minHeight, @RequestParam("maxHeight") Double maxHeight) {
        return userService.findByHeightBetween(minHeight, maxHeight);
    }

    @GetMapping("/totalBurnedCaloriesGreaterThan")
    public List<User> getUsersByTotalBurnedCaloriesGreaterThan(@RequestParam("calories") Double calories) {
        return userService.findByTotalBurnedCaloriesGreaterThan(calories);
    }
}
