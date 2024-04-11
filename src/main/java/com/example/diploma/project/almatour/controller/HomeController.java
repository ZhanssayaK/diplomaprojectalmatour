package com.example.diploma.project.almatour.controller;

import com.example.diploma.project.almatour.service.CategoryService;
import com.example.diploma.project.almatour.service.CityService;
import com.example.diploma.project.almatour.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class HomeController {

    private final UserService userService;
    private final CityService cityService;
    private final CategoryService categoryService;

    @GetMapping(value = "/")
    public String index() {
        return "index";
    }

    @PreAuthorize("isAuthenticated()")
    @GetMapping(value = "/profile")
    public String profile(Model model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String userId = authentication.getName(); // Получаем идентификатор пользователя из объекта аутентификации


        model.addAttribute("userId", userId);
        model.addAttribute("cities", cityService.getCityList());
        model.addAttribute("categories", categoryService.getCategoryList());
        return "profile";
    }

    @GetMapping(value = "/sign-up")
    public String signUp() {
        return "sign-up";
    }

    @GetMapping(value = "/sign-in")
    public String signIn() {
        return "sign-in";
    }

    @GetMapping(value = "/filter")
    public String filter(Model model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String userId = authentication.getName();
        model.addAttribute("userId", userId);
        model.addAttribute("cities", cityService.getCityList());
        model.addAttribute("categories", categoryService.getCategoryList());
        return "filter";
    }
}
