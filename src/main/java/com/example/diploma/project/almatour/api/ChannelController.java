package com.example.diploma.project.almatour.api;

import com.example.diploma.project.almatour.dto.CreateChannelDTO;
import com.example.diploma.project.almatour.model.Channel;
import com.example.diploma.project.almatour.service.ChannelService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/channel")
public class ChannelController {

    private final ChannelService channelService;

    @PostMapping
    public ResponseEntity<Channel> addChannel(@RequestBody CreateChannelDTO body) {
        return ResponseEntity.ok(channelService.createChannelForTour(body));
    }

    @GetMapping(value = "/{userId}")
    public ResponseEntity<List<Channel>> getChannelsByUserId(@PathVariable Long userId) {
        return ResponseEntity.ok(channelService.getChatsForUser(userId));
    }
}
