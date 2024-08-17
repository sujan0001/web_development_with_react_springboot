package com.example.sujanproject.Service;

import com.example.sujanproject.Entity.Novel;
import com.example.sujanproject.Pojo.NovelPojo;

import java.util.List;

public interface NovelService {
    List<Novel> getAllNovels();
    Novel getNovelById(Long id);
    Novel saveNovel(NovelPojo novelPojo);
    void deleteNovel(Long id);
    List<Novel> getNovelsByUserId(Long userId);
}
