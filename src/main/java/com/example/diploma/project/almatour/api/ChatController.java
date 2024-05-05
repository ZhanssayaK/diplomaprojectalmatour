package com.example.diploma.project.almatour.api;

import com.example.diploma.project.almatour.dto.MessageDTO;
import com.example.diploma.project.almatour.mapper.MessageMapper;
import com.example.diploma.project.almatour.model.Message;
import com.example.diploma.project.almatour.service.MessageService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/chat")
@RequiredArgsConstructor
public class ChatController {
    private final MessageService messageService;
    private final MessageMapper messageMapper;
    private final SimpMessagingTemplate messagingTemplate;

    @PostMapping("/send")
    public ResponseEntity<MessageDTO> sendChatMessage(@RequestBody MessageDTO messageDTO) {
        Message message = messageMapper.messageDTOToMessage(messageDTO);
        MessageDTO savedMessage = messageService.saveMessage(message);
        MessageDTO savedMessageDTO = messageMapper.messageToMessageDTO(messageMapper.messageDTOToMessage(savedMessage));
        messagingTemplate.convertAndSendToUser(
                messageDTO.getReceiverId().toString(), "/queue/messages", savedMessageDTO);
        return ResponseEntity.ok(savedMessageDTO);
    }

    @GetMapping("/history/{senderId}/{receiverId}")
    public List<MessageDTO> getMessageHistory(@PathVariable Long senderId, @PathVariable Long receiverId) {
        List<MessageDTO> messageHistory = messageService.getMessageHistoryBetweenUsers(senderId, receiverId);
        messagingTemplate.convertAndSendToUser(
                senderId.toString(), "/queue/messages", messageHistory); // Отправка истории сообщений отправителю
        messagingTemplate.convertAndSendToUser(
                receiverId.toString(), "/queue/messages", messageHistory); // Отправка истории сообщений получателю
        return messageHistory;
    }


}
