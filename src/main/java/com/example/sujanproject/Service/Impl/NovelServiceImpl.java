package com.example.sujanproject.Service.Impl;

import com.example.sujanproject.Entity.Novel;
import com.example.sujanproject.Entity.User;
import com.example.sujanproject.Pojo.NovelPojo;
import com.example.sujanproject.Repo.NovelRepo;
import com.example.sujanproject.Repo.UserRepo;
import com.example.sujanproject.Service.NovelService;
import com.example.sujanproject.utils.ImageToBase64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.io.IOError;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;


@Service


public class NovelServiceImpl implements NovelService {
    @Autowired
    private NovelRepo novelRepo;

    @Autowired
    private UserRepo userRepo;

//    image upload part
//    saving the novel thumbnail to the files directory
    private final String UPLOAD_DIRECTORY=System.getProperty("user.dir")+"/files";

    @Override
    public List<Novel> getAllNovels() {
//        image to base 64 part
        ImageToBase64 imageToBase64 = new ImageToBase64();
        List<Novel> novels = novelRepo.findAll();
        novels= novels.stream().map(nov -> {
            nov.setNovelThumbnail(imageToBase64.getImageToBase64(nov.getNovelThumbnail()));
            return nov;
        }).collect(Collectors.toList());

        return novelRepo.findAll();

    }

    @Override
    public Novel getNovelById(Long id) {
        return novelRepo.findById(id).orElse(null);
    }

    @Override
    public Novel saveNovel(NovelPojo novelPojo) {
        try {
            Novel novel = new Novel();
            // Set fields from novelPojo
            novel.setId(novelPojo.getId());
            novel.setTitle(novelPojo.getTitle());
            novel.setSummary(novelPojo.getSummary());

            // Assume the user is already retrieved or passed in novelPojo
            User user = userRepo.findById(novelPojo.getUserId())
                    .orElseThrow(() -> new RuntimeException("User not found"));
            novel.setUser(user);

            // Set other fields and relationships as needed

//            image upload part
            if (novelPojo.getNovelThumbnail()!=null){
                Path fileNameAndPath=Paths.get(UPLOAD_DIRECTORY,novelPojo.getNovelThumbnail().getOriginalFilename());
                try {
                    Files.write(fileNameAndPath,novelPojo.getNovelThumbnail().getBytes());
                    novel.setNovelThumbnail(novelPojo.getNovelThumbnail().getOriginalFilename());
                } catch (IOException e) {
                    throw new RuntimeException("Error saving novel thumbnail", e);
                }
            }

            return novelRepo.save(novel);
        } catch (Exception e) {

            throw new RuntimeException("Error saving Novel", e);
        }

    }




    @Override
    public void deleteNovel(Long id) {
        novelRepo.deleteById(id);
    }

    @Override
    public List<Novel> getNovelsByUserId(Long userId) {
//        return List.of();
        return novelRepo.findByUserId(userId);
    }

//    @Override
//    public List<Novel> getNovelsByUserId(Long userId) {
//        return novelRepo.findByUserId(userId);
//    }
}
