package com.example.sujanproject.Controller;


import com.example.sujanproject.Entity.Chapter;
import com.example.sujanproject.Entity.Novel;
import com.example.sujanproject.Pojo.ChapterPojo;
import com.example.sujanproject.Service.ChapterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/chapters")
public class ChapterController {
    @Autowired
    private ChapterService chapterService;

    @GetMapping
    public List<Chapter> getAllChapters() {
        return chapterService.getAllChapters();
    }

    @GetMapping("/{id}")
    public Chapter getChapterById(@PathVariable Long id) {
        return chapterService.getChapterById(id);
    }

    @PostMapping
    public ResponseEntity<Chapter> saveChapter(@RequestBody ChapterPojo chapterPojo) {
//        return chapterService.saveChapter(chapter);
        try {
            Chapter savedChapter = chapterService.saveChapter(chapterPojo);
            return new ResponseEntity<>(savedChapter, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @DeleteMapping("/{id}")
    public void deleteChapter(@PathVariable Long id) {
        chapterService.deleteChapter(id);
    }

//    @GetMapping("/novel/{novelId}")
//    public List<Chapter> getChaptersByNovelId(@PathVariable Long novelId) {
//        return chapterService.getChaptersByNovelId(novelId);
//    }
    @GetMapping("/novel/{novelId}")
    public ResponseEntity<List<Chapter>> getChaptersByNovelId(@PathVariable Long novelId) {
        List<Chapter> chapters = chapterService.getChaptersByNovelId(novelId);
        if (chapters.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(chapters, HttpStatus.OK);
    }
}
