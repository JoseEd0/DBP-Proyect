package org.user.infrastructure;


import org.AbstractContainerBaseTest;
import org.user.domain.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;
import java.util.NoSuchElementException;

import static org.assertj.core.api.Assertions.assertThat;

public class UserRepositoryTest extends AbstractContainerBaseTest {
	@Autowired
	private UserRepository userRepository;

    @Test
    public void shouldSaveAndFindUser() {
        User user = new User();
        user.setIdUser(76423857L); 
        user.setFirstName("Alejandro");
        user.setLastName("Escobar");
        user.setEmail("alejandroescobar@gmail.com");
        user.setPassword("password123");
        user.setBirthDate(LocalDate.of(2003, 11, 10));
        userRepository.save(user);
        
        User foundUser = userRepository.findById(76423857L).orElseThrow(() -> new NoSuchElementException("User not found"));
        assertThat(foundUser).isNotNull();
        assertThat(foundUser.getIdUser()).isEqualTo(76423857L);
    }
}