package com.example.diploma.project.almatour.service;

import com.example.diploma.project.almatour.dto.MessageDTO;
import com.example.diploma.project.almatour.mapper.MessageMapper;
import com.example.diploma.project.almatour.model.Message;
import com.example.diploma.project.almatour.repository.MessageRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MessageService {

    private final MessageMapper messageMapper;
    private final MessageRepository messageRepository;

    public MessageDTO saveMessage(Message message) {
        return messageMapper.messageToMessageDTO(messageRepository.save(message));
    }

    public List<MessageDTO> getMessageHistoryBetweenUsers(Long userId1, Long userId2) {
        return messageMapper.toDtoList(messageRepository.findAllBySenderIdAndReceiverIdOrSenderIdAndReceiverIdOrderByCreatedAt(userId1, userId2, userId2, userId1));
    }
}
