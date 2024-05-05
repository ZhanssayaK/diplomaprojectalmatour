package com.example.diploma.project.almatour.repository;

import com.example.diploma.project.almatour.model.Channel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public interface ChannelRepository extends JpaRepository<Channel, Long> {
    @Query("SELECT c FROM Channel c JOIN c.participants p WHERE p.id = :userId")
    List<Channel> findAllByParticipantId(@Param("userId") Long userId);
}
