package com.example.sujanproject.Repo;

import com.example.sujanproject.Entity.Chapter;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ChapterRepo extends JpaRepository<Chapter, Long> {
    List<Chapter> findByNovelId(Long novelId);
}
