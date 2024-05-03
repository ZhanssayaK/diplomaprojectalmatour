package com.example.diploma.project.almatour.repository;

import com.example.diploma.project.almatour.model.FeedBack;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FeedBackRepository extends JpaRepository<FeedBack,Long> {
    List<FeedBack> findByAccommodation_Id(Long accommodationId);
}
