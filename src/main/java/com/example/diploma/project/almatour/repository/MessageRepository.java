package com.example.diploma.project.almatour.repository;

import com.example.diploma.project.almatour.model.Message;
import com.example.diploma.project.almatour.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MessageRepository extends JpaRepository<Message,Long> {
    List<Message> findByReceiverId(Long receiverId);
    List<Message> findAllBySenderIdAndReceiverIdOrSenderIdAndReceiverIdOrderByCreatedAt(
            Long senderId1, Long receiverId1, Long senderId2, Long receiverId2);
    List<Message> findAllByReceiverId(Long id);
}
