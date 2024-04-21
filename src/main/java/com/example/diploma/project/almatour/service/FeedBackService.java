package com.example.diploma.project.almatour.service;

import com.example.diploma.project.almatour.dto.AccommodationDTO;
import com.example.diploma.project.almatour.dto.AccommodationDetailDTO;
import com.example.diploma.project.almatour.dto.FeedBackDTO;
import com.example.diploma.project.almatour.mapper.AccommodationMapper;
import com.example.diploma.project.almatour.mapper.FeedBackMapper;
import com.example.diploma.project.almatour.model.FeedBack;
import com.example.diploma.project.almatour.repository.FeedBackRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FeedBackService {
    private final FeedBackRepository feedBackRepository;
    private final FeedBackMapper feedBackMapper;
    private final AccommodationMapper accommodationMapper;

    public FeedBackDTO addFeedBack(FeedBackDTO feedBackDTO) {
        FeedBack feedBack = feedBackMapper.toEntity(feedBackDTO);
        return feedBackMapper.toDto(feedBackRepository.save(feedBack));
    }

    public List<FeedBackDTO> getFeedBacks(AccommodationDetailDTO accommodationDetailDTO) {
        return feedBackMapper.
                toDtoList(feedBackRepository.
                        findAllByAccommodationOrderByAddedTimeDesc
                                (accommodationMapper.
                                        toEntityDetail(accommodationDetailDTO)));
    }
}
