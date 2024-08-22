package com.example.sujanproject.Repo;

import com.example.sujanproject.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepo extends JpaRepository<User,Long> {
    User findByEmail(String email);

}
