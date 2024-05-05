package com.example.diploma.project.almatour.dto;

import com.example.diploma.project.almatour.model.User;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.sql.Timestamp;

@Getter
@Setter
@Builder
public class MessageDTO {

    private Long id;
    private String message;
    private Timestamp createdAt;
    private Long senderId;
    private Long receiverId;
}
