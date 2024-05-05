package com.example.diploma.project.almatour.api;

import com.example.diploma.project.almatour.dto.CreateChannelMessageDTO;
import com.example.diploma.project.almatour.model.ChannelMessage;
import com.example.diploma.project.almatour.service.ChannelMessageService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/channel/message")
public class ChannelMessageController {

    private final ChannelMessageService channelMessageService;

    @MessageMapping("/sendMessage/{channelId}")
    @SendTo("/tour/receiveMessage/{channelId}")
    public ResponseEntity<ChannelMessage> sendMessage(@DestinationVariable Long channelId, @RequestBody CreateChannelMessageDTO dto) {
        return ResponseEntity.ok(channelMessageService.saveMessage(channelId, dto));
    }

    @GetMapping(value = "/{channelId}")
    public ResponseEntity<List<ChannelMessage>> getMessages(@PathVariable Long channelId) {
        return ResponseEntity.ok(channelMessageService.getMessagesForChannel(channelId));
    }
}
