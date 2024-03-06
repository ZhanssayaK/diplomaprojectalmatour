package com.example.diploma.project.almatour.api;

import com.example.diploma.project.almatour.dto.AccommodationDTO;
import com.example.diploma.project.almatour.service.AccomodationService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/accomodations")
public class AccomodationController {
    private final AccomodationService accomodationService;

    @GetMapping
    public List<AccommodationDTO> getAccomodations(){
        return accomodationService.getAccomodations();
    }

    @PostMapping
    public AccommodationDTO addAccomodation(@RequestBody AccommodationDTO accommodation){
        return accomodationService.addAccommodation(accommodation);
    }

    @PutMapping
    public AccommodationDTO updateAccomodation(@RequestBody AccommodationDTO accommodation){
        return accomodationService.updateAccommodation(accommodation);
    }

    @GetMapping(value = "{id}")
    public AccommodationDTO getAccommodation(@PathVariable(name = "id") Long id){
        return accomodationService.getAccommodation(id);
    }

    @DeleteMapping(value = "{id}")
    public void deleteAccommodation(@PathVariable(name = "id") Long id){
        accomodationService.deleteAccommodation(id);
    }
}
