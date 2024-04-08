package com.example.diploma.project.almatour.service;

import com.example.diploma.project.almatour.dto.AccommodationDTO;
import com.example.diploma.project.almatour.dto.AccommodationShowDTO;
import com.example.diploma.project.almatour.mapper.AccommodationMapper;
import com.example.diploma.project.almatour.mapper.AccommodationShowMapper;
import com.example.diploma.project.almatour.mapper.UserMapper;
import com.example.diploma.project.almatour.model.Accommodation;
import com.example.diploma.project.almatour.model.AccommodationPhoto;
import com.example.diploma.project.almatour.repository.AccommodationPhotoRepository;
import com.example.diploma.project.almatour.repository.AccomodationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.net.MalformedURLException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AccomodationService {

    @Value("${file.places.show}")
    private String showPath;

    private final UserService userService;
    private final UserMapper userMapper;

    private final AccomodationRepository accomodationRepository;
    private final AccommodationMapper accommodationMapper;
    private final AccommodationShowMapper accommodationShowMapper;
    private final AccommodationPhotoRepository accommodationPhotoRepository;

    public List<AccommodationShowDTO> getAccomodations() throws MalformedURLException {
        List<Accommodation> accommodations = accomodationRepository.findAll();
        List<AccommodationShowDTO> result = new ArrayList<>();
        for (Accommodation ac : accommodations) {
            List<AccommodationPhoto> photos = accommodationPhotoRepository.findAllByAccommodationId(ac.getId());
            String path = Paths.get(showPath, photos.get(0).getPath() + ".jpg").toString();
            AccommodationShowDTO dto = AccommodationShowDTO.builder()
                    .name(ac.getName())
                    .location(ac.getLocation())
                    .startTime(ac.getStartTime())
                    .path(path)
                    .build();
            result.add(dto);
        }
        return result;
    }

    public AccommodationDTO addAccommodation(AccommodationDTO dto) {
        Accommodation accommodation = accommodationMapper.toEntity(dto);
        return accommodationMapper.toDto(accomodationRepository.save(accommodation));
    }


    public AccommodationDTO getAccommodation(Long id) {
        return accommodationMapper.toDto(accomodationRepository.findById(id).orElseThrow());
    }

    public AccommodationDTO updateAccommodation(AccommodationDTO dto) {
        return accommodationMapper.toDto(accomodationRepository.save(accommodationMapper.toEntity(dto)));
    }

    public void deleteAccommodation(Long id) {
        accomodationRepository.deleteById(id);
    }
}
