package com.example.diploma.project.almatour.repository;

import com.example.diploma.project.almatour.model.Accommodation;
import com.example.diploma.project.almatour.model.FeedBack;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public interface FeedBackRepository extends JpaRepository<FeedBack, Long> {
    List<FeedBack> findAllByAccommodationOrderByAddedTimeDesc(Accommodation accommodation);
}
