package com.example.sujanproject.Service;

import com.example.sujanproject.Entity.Chapter;
import com.example.sujanproject.Pojo.ChapterPojo;

import java.util.List;

public interface ChapterService {
    List<Chapter> getAllChapters();
    Chapter getChapterById(Long id);
//    Chapter saveChapter(Chapter chapter);
    Chapter saveChapter(ChapterPojo chapterPojo);
    void deleteChapter(Long id);
    List<Chapter> getChaptersByNovelId(Long novelId);
}
