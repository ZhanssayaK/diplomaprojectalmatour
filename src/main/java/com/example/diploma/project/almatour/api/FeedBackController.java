package com.example.diploma.project.almatour.api;

import com.example.diploma.project.almatour.dto.FeedBackDTO;
import com.example.diploma.project.almatour.service.FeedBackService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/feedbacks")
public class FeedBackController {

    private final FeedBackService feedBackService;

    @GetMapping(value = "/all/{accomodationId}")
    public List<FeedBackDTO> getFeedBacksByAccomodation(@PathVariable(value = "accomodationId") Long id){
        return feedBackService.getFeedbacksByAccommodation(id);
    }

    @PostMapping(value = "/add")
    public void addFeedBack(@RequestBody FeedBackDTO feedBack){
         feedBackService.addFeedBack(feedBack);
    }
}
