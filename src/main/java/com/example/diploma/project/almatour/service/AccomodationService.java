package com.example.diploma.project.almatour.service;

import com.example.diploma.project.almatour.dto.AccommodationDTO;
import com.example.diploma.project.almatour.mapper.AccommodationMapper;
import com.example.diploma.project.almatour.model.Accommodation;
import com.example.diploma.project.almatour.repository.AccomodationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AccomodationService {

    private final AccomodationRepository accomodationRepository;
    private final AccommodationMapper accommodationMapper;

    public List<AccommodationDTO> getAccomodations(){
        List<Accommodation> accommodations = accomodationRepository.findAll();
        return accommodationMapper.toDtoList(accommodations);
    }

    public AccommodationDTO addAccommodation(AccommodationDTO dto){
        Accommodation accommodation = accommodationMapper.toEntity(dto);
        return accommodationMapper.toDto(accomodationRepository.save(accommodation));
    }


    public AccommodationDTO getAccommodation(Long id){
        return accommodationMapper.toDto(accomodationRepository.findById(id).orElseThrow());
    }

    public AccommodationDTO updateAccommodation(AccommodationDTO dto){
        return accommodationMapper.toDto(accomodationRepository.save(accommodationMapper.toEntity(dto)));
    }

    public void deleteAccommodation(Long id){
        accomodationRepository.deleteById(id);
    }
}
