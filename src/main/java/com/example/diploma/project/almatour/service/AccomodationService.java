package com.example.diploma.project.almatour.service;

import com.example.diploma.project.almatour.dto.AccommodationDTO;
import com.example.diploma.project.almatour.dto.AccommodationDetailDTO;
import com.example.diploma.project.almatour.dto.AccommodationSearchDTO;
import com.example.diploma.project.almatour.dto.AccommodationShowDTO;
import com.example.diploma.project.almatour.exception.AccommmodationExistException;
import com.example.diploma.project.almatour.mapper.AccommodationMapper;
import com.example.diploma.project.almatour.mapper.UserMapper;
import com.example.diploma.project.almatour.model.Accommodation;
import com.example.diploma.project.almatour.model.AccommodationPhoto;
import com.example.diploma.project.almatour.repository.AccommodationPhotoRepository;
import com.example.diploma.project.almatour.repository.AccomodationRepository;
import com.example.diploma.project.almatour.specification.AccommodationSpecification;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.net.MalformedURLException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AccomodationService {

    @Value("${file.places.show}")
    private String showPath;

    @Value("${file.places.uploadpath}")
    private String ptah;

    private final UserService userService;
    private final UserMapper userMapper;

    private final AccomodationRepository accomodationRepository;
    private final AccommodationMapper accommodationMapper;
    private final AccommodationPhotoRepository accommodationPhotoRepository;

    public List<AccommodationShowDTO> getAccomodations(AccommodationSearchDTO searchDto) throws MalformedURLException {
        List<Accommodation> accommodations = accomodationRepository.findAll(AccommodationSpecification.accommodationSpecification(searchDto));
        List<AccommodationShowDTO> result = new ArrayList<>();
        for (Accommodation ac : accommodations) {
            List<AccommodationPhoto> photos = accommodationPhotoRepository.findAllByAccommodationId(ac.getId());
            AccommodationShowDTO dto = AccommodationShowDTO.builder()
                    .id(ac.getId())
                    .name(ac.getName())
                    .location(ac.getLocation())
                    .startTime(ac.getStartTime())
                    .build();
            if (!photos.isEmpty()) {
                String path = Paths.get(showPath, photos.get(0).getPath() + ".jpg").toString();
                dto.setPath(path);
            }
            result.add(dto);
        }
        return result;
    }

    public AccommodationDTO addAccommodation(AccommodationDTO dto) {
        if (accomodationRepository.findByName(dto.getName()) != null) {
            throw new AccommmodationExistException("Accommodation is exist", HttpStatus.BAD_REQUEST);
        }
        Accommodation accommodation = accommodationMapper.toEntity(dto);
        return accommodationMapper.toDto(accomodationRepository.save(accommodation));
    }


    public AccommodationDetailDTO getAccommodation(Long id) {
        Accommodation accommodation = accomodationRepository.findById(id).orElseThrow();
        List<AccommodationPhoto> photos = accommodationPhotoRepository.findAllByAccommodationId(accommodation.getId());
        AccommodationDetailDTO dto = accommodationMapper.toDtoDetail(accommodation);
//            AccommodationShowDTO.builder()
//                    .id(accommodation.getId())
//                    .name(accommodation.getName())
//                    .location(accommodation.getLocation())
//                    .startTime(accommodation.getStartTime())
//                    .build();
        if (!photos.isEmpty()) {
            String path = Paths.get(showPath, photos.get(0).getPath() + ".jpg").toString();
            dto.setPath(Arrays.asList(path));
        }
        return dto;
//        result.add(dto);
//        return accommodationMapper.toDtoDetail(accomodationRepository.findById(id).
    }

    public AccommodationDTO updateAccommodation(AccommodationDTO dto) {
        return accommodationMapper.toDto(accomodationRepository.save(accommodationMapper.toEntity(dto)));
    }

    public void deleteAccommodation(Long id) {
        accomodationRepository.deleteById(id);
    }
}
