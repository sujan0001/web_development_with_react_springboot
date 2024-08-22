package com.example.sujanproject;

import com.example.sujanproject.Entity.User;
import com.example.sujanproject.Repo.UserRepo;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import java.util.List;
import java.util.Optional;

@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@DataJpaTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class UserRepositoryTests {

    @Autowired
    private UserRepo userRepo;

    @Test
    @Order(1)
    @Rollback(value = false)
    public void saveUserTest() {
        User user = User.builder()
                .username("john_doe")
                .password("password123")
                .build();

        userRepo.save(user);

        Assertions.assertThat(user.getId()).isGreaterThan(0);
    }

    @Test
    @Order(2)
    public void getUserTest() {
        User user = userRepo.findById(1L).orElse(null);
        Assertions.assertThat(user).isNotNull();
        Assertions.assertThat(user.getId()).isEqualTo(1L);
    }

    @Test
    @Order(3)
    public void getListOfUsersTest() {
        List<User> users = userRepo.findAll();
        Assertions.assertThat(users.size()).isGreaterThan(0);
    }


    @Test
    @Order(5)
    @Rollback(value = false)
    public void deleteUserTest() {
        User user = userRepo.findById(1L).orElse(null);
        Assertions.assertThat(user).isNotNull();

        userRepo.delete(user);

        Optional<User> deletedUser = userRepo.findById(1L);
        Assertions.assertThat(deletedUser).isEmpty();
    }
}
