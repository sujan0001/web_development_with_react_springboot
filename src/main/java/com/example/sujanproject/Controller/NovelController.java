package com.example.sujanproject.Controller;


import com.example.sujanproject.Entity.Novel;
import com.example.sujanproject.Pojo.NovelPojo;
import com.example.sujanproject.Service.NovelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/novels")
public class NovelController {
    @Autowired
    private NovelService novelService;

    @GetMapping
    public List<Novel> getAllNovels() {
        return novelService.getAllNovels();
    }

    @GetMapping("/{id}")
    public Novel getNovelById(@PathVariable Long id) {
        return novelService.getNovelById(id);
    }

    @PostMapping("/save")
    public ResponseEntity<Novel> saveNovel(@RequestBody @ModelAttribute NovelPojo novelPojo) {
        try {
            Novel savedNovel = novelService.saveNovel(novelPojo);
            return new ResponseEntity<>(savedNovel, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/{id}")
    public void deleteNovel(@PathVariable Long id) {
        novelService.deleteNovel(id);
    }

    @GetMapping("/user/{userId}")
    public List<Novel> getNovelsByUserId(@PathVariable Long userId) {
        return novelService.getNovelsByUserId(userId);
    }

}
