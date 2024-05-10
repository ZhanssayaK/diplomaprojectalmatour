package com.example.diploma.project.almatour.api;

import com.example.diploma.project.almatour.dto.MessageDTO;
import com.example.diploma.project.almatour.mapper.MessageMapper;
import com.example.diploma.project.almatour.model.Message;
import com.example.diploma.project.almatour.service.MessageService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
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

    @MessageMapping("/send/{senderId}/{receiverId}")
    @SendTo({"/topic/receiveMessage/{senderId}/{receiverId}", "/topic/receiveMessage/{receiverId}/{senderId}"})
    public ResponseEntity<MessageDTO> sendChatMessage(@DestinationVariable String senderId, @DestinationVariable String receiverId,@RequestBody MessageDTO messageDTO) {
        Message message = messageMapper.messageDTOToMessage(messageDTO);
        MessageDTO savedMessage = messageService.saveMessage(message);
        return ResponseEntity.ok(savedMessage);
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
