package com.example.sujanproject.Service.Impl;

import com.example.sujanproject.Entity.Chapter;
import com.example.sujanproject.Entity.Novel;
import com.example.sujanproject.Entity.User;
import com.example.sujanproject.Pojo.ChapterPojo;
import com.example.sujanproject.Repo.ChapterRepo;
import com.example.sujanproject.Repo.NovelRepo;
import com.example.sujanproject.Service.ChapterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ChapterServiceImpl implements ChapterService {
    @Autowired
    private ChapterRepo chapterRepo;

    @Autowired
    private NovelRepo novelRepo;

    @Override
    public List<Chapter> getAllChapters() {
        return chapterRepo.findAll();
    }

    @Override
    public Chapter getChapterById(Long id) {
        return chapterRepo.findById(id).orElse(null);
    }

    @Override
    public Chapter saveChapter(ChapterPojo chapterPojo) {
//        return null;
        try {
            Chapter chapter = new Chapter();
            chapter.setTitle(chapterPojo.getTitle());
            chapter.setContent(chapterPojo.getContent());

            // Fetch the associated Novel entity
            Novel novel = novelRepo.findById(chapterPojo.getNovelId())
                    .orElseThrow(() -> new RuntimeException("Novel not found"));
            chapter.setNovel(novel);

            // Save and return the chapter
            return chapterRepo.save(chapter);
        } catch (Exception e) {
            // Handle and log the error
            throw new RuntimeException("Error saving Chapter", e);
        }
    }

//    @Override
//    public Chapter saveChapter(ChapterPojo chapterPojo) {
//        return chapterRepo.save(chapter);
//    }

    @Override
    public void deleteChapter(Long id) {
        chapterRepo.deleteById(id);
    }

    @Override
    public List<Chapter> getChaptersByNovelId(Long novelId) {
//        return List.of();
        return chapterRepo.findByNovelId(novelId);
    }

//    @Override
//    public List<Chapter> getChaptersByNovelId(Long novelId) {
//        return chapterRepo.findByNovelId(novelId);
//    }

}
