package com.example.diploma.project.almatour.controller;

import com.example.diploma.project.almatour.dto.AccommodationDetailDTO;
import com.example.diploma.project.almatour.model.User;
import com.example.diploma.project.almatour.service.*;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
@RequiredArgsConstructor
public class HomeController {

    private final UserService userService;
    private final CityService cityService;
    private final CategoryService categoryService;
    private final AuthenticationService authenticationService;

    private final AccomodationService accomodationService;

    @GetMapping(value = "/")
    public String index() {
        return "index";
    }

    @PreAuthorize("isAuthenticated()")
    @GetMapping(value = "/profile")
    public String profile(Model model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String userId = authentication.getName();
        model.addAttribute("userId", userId);
        model.addAttribute("cities", cityService.getCityList());
        model.addAttribute("categories", categoryService.getCategoryList());
        model.addAttribute("currentUser", authenticationService.getCurrentUser());
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

    @GetMapping(value = "accommodationdetail/{id}")
    public String getAccommodation(@PathVariable(name = "id") Long id,
                                   Model model) {
        AccommodationDetailDTO accommodation = accomodationService.getAccommodation(id);
        model.addAttribute("accommodation", accommodation);

        User user = authenticationService.getCurrentUser();
        model.addAttribute("onlineUser", user);
        return "detailspage";
    }

    @GetMapping(value = "/messages")
    public String messages() {
        return "messages";
    }
}
