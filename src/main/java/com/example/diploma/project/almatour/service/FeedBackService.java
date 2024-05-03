package com.example.diploma.project.almatour.service;

import com.example.diploma.project.almatour.dto.FeedBackDTO;
import com.example.diploma.project.almatour.mapper.FeedBackMapper;
import com.example.diploma.project.almatour.repository.FeedBackRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class FeedBackService {

    private final FeedBackRepository feedBackRepository;
    private final FeedBackMapper feedBackMapper;

    public List<FeedBackDTO> getFeedbacksByAccommodation(Long accommodationId) {
        return feedBackMapper.toDtoList(feedBackRepository.findByAccommodation_Id(accommodationId));
    }

    public void addFeedBack(FeedBackDTO feedBackDTO){
        feedBackDTO.setAddedTime(LocalDateTime.now());
        feedBackRepository.save(feedBackMapper.toEntity(feedBackDTO));
    }
}
