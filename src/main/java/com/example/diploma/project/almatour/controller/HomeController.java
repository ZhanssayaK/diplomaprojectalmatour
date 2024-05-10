package com.example.diploma.project.almatour.controller;

import com.example.diploma.project.almatour.dto.AccommodationDetailDTO;
import com.example.diploma.project.almatour.model.Channel;
import com.example.diploma.project.almatour.model.ChannelMessage;
import com.example.diploma.project.almatour.model.User;
import com.example.diploma.project.almatour.repository.ChannelRepository;
import com.example.diploma.project.almatour.service.*;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class HomeController {

    private final UserService userService;
    private final CityService cityService;
    private final CategoryService categoryService;
    private final AuthenticationService authenticationService;
    private final ChannelMessageService channelMessageService;

    private final AccomodationService accomodationService;
    private final ChannelRepository channelRepository;
    private final RegistrationService registrationService;

    @GetMapping(value = "/")
    public String index() {
        return "index";
    }

    @PostMapping("/savePasswordd")
    public String savePassword(@RequestParam(name = "user_old_password") String oldPassword,
                               @RequestParam(name = "user_new_password") String newPassword,
                               @RequestParam(name = "user_repeat_new_password") String repeatNewPassword){

        System.out.println(oldPassword);
        System.out.println(newPassword);
        Boolean result = registrationService.updatePassword(oldPassword, newPassword, repeatNewPassword);

        if(result != null){
            if(result){
                return "redirect:/profile?success";
            }

            return "redirect:/profile?newPasswordError";
        }

        return "redirect:/profile?oldPasswordError";
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

    @PreAuthorize("isAuthenticated()")
    @GetMapping(value = "/messages-page/{userId}")
    public String messages(@PathVariable(value = "userId") Long id,
                           Model model) {
        User user = authenticationService.getCurrentUser();
        model.addAttribute("onlineUser", user);
        return "messages";
    }

    @PreAuthorize("isAuthenticated()")
    @GetMapping(value = "/myAccommodationsDetailsShow/{id}")
    public String myAccomodationsDetialsShow(@PathVariable(value = "id") Long accomodationId) {
        return "myAccomodationsDetialsShow";
    }

    @PreAuthorize("isAuthenticated()")
    @GetMapping(value = "/myMessages/{currentUserId}")
    public String myMessages(@PathVariable(value = "currentUserId") Long currentUserId) {
        return "myMessages";
    }

    @PreAuthorize("isAuthenticated()")
    @GetMapping(value = "/channelMessages/{id}")
    public String channelMessages(@PathVariable(value = "id") Long channelId, Model model) {
        Channel channel = channelRepository.findById(channelId).get();
        List<ChannelMessage> channelMessageList = channelMessageService.getMessagesForChannel(channelId);
        model.addAttribute("channelId", channelId);
        model.addAttribute("userId", authenticationService.getCurrentUser().getId());
        model.addAttribute("channelName", channel.getName());
        if (!channelMessageList.isEmpty()) {
            model.addAttribute("messages", channelMessageList);
        }
        model.addAttribute("memberCount",channel.getParticipants().size());
        return "channelMessenger";
    }
}
