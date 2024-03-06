package com.example.diploma.project.almatour.repository;

import com.example.diploma.project.almatour.model.Role;
import com.example.diploma.project.almatour.model.User;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public interface RoleRepository extends JpaRepository<Role,Long> {
    Role findByName(String name);
}
