package com.example.diploma.project.almatour.repository;

import com.example.diploma.project.almatour.model.CreditCardDetails;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public interface CreditCardDetailsRepository extends JpaRepository<CreditCardDetails, Long> {

}
