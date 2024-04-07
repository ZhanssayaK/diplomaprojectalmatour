package com.example.diploma.project.almatour.repository;

import com.example.diploma.project.almatour.model.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface CityRepository extends JpaRepository<City,Long> {
}
