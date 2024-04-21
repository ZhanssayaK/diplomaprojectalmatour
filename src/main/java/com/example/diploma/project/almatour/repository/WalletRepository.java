package com.example.diploma.project.almatour.repository;

import com.example.diploma.project.almatour.model.User;
import com.example.diploma.project.almatour.model.Wallet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WalletRepository extends JpaRepository<Wallet,Long> {
    Wallet findByUser(User user);
}
