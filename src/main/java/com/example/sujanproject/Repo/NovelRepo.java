package com.example.sujanproject.Repo;

import com.example.sujanproject.Entity.Novel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface NovelRepo extends JpaRepository<Novel, Long> {
    List<Novel> findByUserId(Long userId);
}
