package com.example.diploma.project.almatour.repository;

import com.example.diploma.project.almatour.model.City;
import com.example.diploma.project.almatour.model.User;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Transactional
public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmail(String email);
    @Query("SELECT u FROM User u JOIN u.roles r WHERE r.id = :roleId")
    List<User> findByRoleId(@Param("roleId") Long roleId);

    @Query("SELECT u FROM User u JOIN Booking b on u.id=b.user.id where b.accommodation.id=:accommodationId")
    List<User> findAllByAccommodationId(@Param("accommodationId") Long accommodationId);
}