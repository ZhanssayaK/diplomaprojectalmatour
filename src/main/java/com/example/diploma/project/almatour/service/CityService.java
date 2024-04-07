package com.example.diploma.project.almatour.service;

import com.example.diploma.project.almatour.model.City;
import com.example.diploma.project.almatour.repository.CityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CityService {

    private final CityRepository cityRepository;

    public List<City> getCityList() {
        return cityRepository.findAll();
    }
}
