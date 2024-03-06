package com.example.diploma.project.almatour.controller;

import com.example.diploma.project.almatour.service.RegistrationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequiredArgsConstructor
public class RegisterController {

    private final RegistrationService registerService;

    @PostMapping(value = "/to-sign-up")
    public String toRegister(@RequestParam(name = "user_fullName") String fullName,
                             @RequestParam(name = "user_email") String email,
                             @RequestParam(name = "user_password") String password,
                             @RequestParam(name = "user_repassword") String rePassword){
        Boolean result = registerService.registerUser(email,password,rePassword,fullName);
        if (result != null) {
            if (result){
                return "redirect:/sign-up?success";
            }
        }
        return "redirect:/sign-up?error";
    }
}
