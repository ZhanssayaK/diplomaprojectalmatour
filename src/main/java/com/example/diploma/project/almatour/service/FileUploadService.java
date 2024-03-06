package com.example.diploma.project.almatour.service;

import com.example.diploma.project.almatour.model.User;
import org.apache.commons.codec.cli.Digest;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Service
public class FileUploadService {

    @Autowired
    private AuthenticationService userService;

    public void uploadPicture(MultipartFile file){
        try {
            if (file.getContentType().equals("image/jpg") || file.getContentType().equals("image/jpeg")){
                byte bytes[] = file.getBytes();
                String filePath = "build/resources/main/static/images/";
                String fileName = DigestUtils.sha1Hex(userService.getCurrentUser().getId()+"_diplomaprojectalmatour!") + ".jpg";
                Path path = Paths.get(filePath+fileName);
                Files.write(path,bytes);

                User user = userService.getCurrentUser();
                user.setAvatarUrl(fileName);
                userService.updateUser(user);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
