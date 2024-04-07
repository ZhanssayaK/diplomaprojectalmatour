package com.example.diploma.project.almatour.api;

import com.example.diploma.project.almatour.dto.AccommodationDTO;
import com.example.diploma.project.almatour.mapper.AccommodationMapper;
import com.example.diploma.project.almatour.model.AccommodationPhoto;
import com.example.diploma.project.almatour.repository.AccommodationPhotoRepository;
import com.example.diploma.project.almatour.service.AccomodationService;
import com.example.diploma.project.almatour.service.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Objects;
import java.util.Random;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/accommodations")
public class AccomodationController {
    private final AccomodationService accomodationService;
    private final AccommodationPhotoRepository accommodationPhotoRepository;
    private final AuthenticationService authenticationService;
    private final AccommodationMapper accommodationMapper;

    @Value("${file.places.uploadpath}")
    private String uploadPath;

    @GetMapping
    public List<AccommodationDTO> getAccomodations() {
        return accomodationService.getAccomodations();
    }

    @PostMapping()
    public ResponseEntity<AccommodationDTO> addAccomodation(@RequestBody AccommodationDTO dto
    ) {
        return ResponseEntity.ok(accomodationService.addAccommodation(dto));
    }

    @PostMapping(value = "/uploadFiles", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<AccommodationDTO> addAccomodation(@RequestPart("photos") MultipartFile[] photos,
                                                            @RequestPart("id") String id) {
        for (MultipartFile file : photos) {
            if (Objects.equals(file.getContentType(), "image/jpg") || Objects.equals(file.getContentType(), "image/jpeg")) {
                try {
                    Random rand = new Random();
                    int randInt = rand.nextInt();
                    byte[] bytes = file.getBytes();
                    String fileName = DigestUtils.sha1Hex(authenticationService.getCurrentUser().getId() + randInt + "_diplomaprojectalmatour!");
                    Path path = Paths.get(uploadPath + fileName + ".jpg");
                    Files.write(path, bytes);
                    AccommodationDTO accommodation = accomodationService.getAccommodation(Long.valueOf(id));

                    AccommodationPhoto photo = new AccommodationPhoto();
                    photo.setAccommodation(accommodationMapper.toEntity(accommodation));
                    photo.setName(fileName);
                    accommodationPhotoRepository.save(photo);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return null;
    }

    @PutMapping
    public AccommodationDTO updateAccomodation(@RequestBody AccommodationDTO accommodation) {
        return accomodationService.updateAccommodation(accommodation);
    }

    @GetMapping(value = "{id}")
    public AccommodationDTO getAccommodation(@PathVariable(name = "id") Long id) {
        return accomodationService.getAccommodation(id);
    }

    @DeleteMapping(value = "{id}")
    public void deleteAccommodation(@PathVariable(name = "id") Long id) {
        accomodationService.deleteAccommodation(id);
    }
}
