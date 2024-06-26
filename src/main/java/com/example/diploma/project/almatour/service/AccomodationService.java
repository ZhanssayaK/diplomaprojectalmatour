package com.example.diploma.project.almatour.service;

import com.example.diploma.project.almatour.dto.*;
import com.example.diploma.project.almatour.exception.AccommmodationExistException;
import com.example.diploma.project.almatour.mapper.AccommodationMapper;
import com.example.diploma.project.almatour.mapper.AccommodationShowMapper;
import com.example.diploma.project.almatour.mapper.MyAccomodationFunctionMapper;
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
import org.springframework.transaction.annotation.Transactional;

import java.net.MalformedURLException;
import java.nio.file.Paths;
import java.util.ArrayList;
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
    private final AccommodationShowMapper accommodationShowMapper;
    private final AccommodationMapper accommodationMapper;
    private final AccommodationPhotoRepository accommodationPhotoRepository;
    private final MyAccomodationFunctionMapper myAccomodationFunctionMapper;

    public List<AccommodationShowDTO> getAccomodations(AccommodationSearchDTO searchDto) throws MalformedURLException {
        List<Accommodation> accommodations = accomodationRepository.findAll(AccommodationSpecification.accommodationSpecification(searchDto));
        List<AccommodationShowDTO> result = new ArrayList<>();
        for (Accommodation ac : accommodations) {
            List<AccommodationPhoto> photos = accommodationPhotoRepository.findAllByAccommodationId(ac.getId());

            AccommodationShowDTO dto = accommodationShowMapper.toDto(ac);
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
        if (!photos.isEmpty()) {
            List<String> otherPhotos = new ArrayList<>();

            for (int i = 0; i < photos.size(); i++) {
                String photoPath = Paths.get(showPath, photos.get(i).getPath() + ".jpg").toString();

                if (i == 0) {
                    dto.setMainPhoto(photoPath);
                } else {
                    otherPhotos.add(photoPath);
                }
            }
            dto.setOtherPhoto(otherPhotos);
        }

        return dto;
    }

    public AccommodationDTO updateAccommodation(AccommodationDTO dto) {
        return accommodationMapper.toDto(accomodationRepository.save(accommodationMapper.toEntity(dto)));
    }

    @Transactional
    public void deleteAccommodation(Long id) {
        accommodationPhotoRepository.deleteAccommodationPhotosByAccommodationId(id);
        accomodationRepository.deleteById(id);
    }

    public void rejectAccommodation(RejectDTO dto) {
        if (accomodationRepository.findById(dto.getId()).isPresent()) {
            Accommodation accommodation = accomodationRepository.findById(dto.getId()).get();
            accommodation.setComment(dto.getComment());
            accommodation.setStatus(false);
            accomodationRepository.save(accommodation);
        }
    }

    public void acceptAccommodation(Long id) {
        if (accomodationRepository.findById(id).isPresent()) {
            Accommodation accommodation = accomodationRepository.findById(id).get();
            accommodation.setComment("");
            accommodation.setStatus(true);
            accomodationRepository.save(accommodation);
        }
    }

    public List<AccommodationDTO> getAccomodationsByUserId(Long userId) {
        List<AccommodationDTO> dtoList = accommodationMapper.toDtoList(accomodationRepository.findByUserId(userId));
        for (AccommodationDTO dto : dtoList) {
            List<AccommodationPhoto> photos = accommodationPhotoRepository.findAllByAccommodationId(dto.getId());

            if (!photos.isEmpty()) {
                String path = Paths.get(showPath, photos.get(0).getPath() + ".jpg").toString();
                dto.setMainPhoto(path);
            }
        }
        return dtoList;
    }

    public MyAccomodationFunctionDTO getAccomodationById(Long id) {
        MyAccomodationFunctionDTO dto = myAccomodationFunctionMapper.toDto(accomodationRepository.findById(id).orElse(null));
        List<AccommodationPhoto> photos = accommodationPhotoRepository.findAllByAccommodationId(id);

        if (!photos.isEmpty()) {
            String path = Paths.get(showPath, photos.get(0).getPath() + ".jpg").toString();
            dto.setMainPhoto(path);
        }
        return dto;
    }
}
