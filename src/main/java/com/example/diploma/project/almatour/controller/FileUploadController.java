package com.example.diploma.project.almatour.controller;

import com.example.diploma.project.almatour.service.FileUploadService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequiredArgsConstructor
public class FileUploadController {

    private final FileUploadService fileUploadService;

    @PostMapping(value = "/upload-avatar")
    public String uploadAvatar(@RequestParam(name = "avatar") MultipartFile file){
        fileUploadService.uploadPicture(file);
        return "redirect:/profile";
    }
}