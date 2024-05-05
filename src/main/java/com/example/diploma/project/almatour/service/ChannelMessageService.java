package com.example.diploma.project.almatour.service;

import com.example.diploma.project.almatour.dto.CreateChannelMessageDTO;
import com.example.diploma.project.almatour.model.ChannelMessage;
import com.example.diploma.project.almatour.repository.ChannelMessageRepository;
import com.example.diploma.project.almatour.repository.ChannelRepository;
import com.example.diploma.project.almatour.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ChannelMessageService {

    private final ChannelMessageRepository channelMessageRepository;
    private final UserRepository userRepository;
    private final AuthenticationService authenticationService;
    private final ChannelRepository channelRepository;

    public ChannelMessage saveMessage(Long channelId, CreateChannelMessageDTO dto) {
        ChannelMessage channelMessage = new ChannelMessage();
        channelMessage.setContent(dto.getContent());
        channelMessage.setSender(userRepository.findById(dto.getUserId()).get());
        channelMessage.setChannel(channelRepository.findById(channelId).get());
        return channelMessageRepository.save(channelMessage);
    }

    public List<ChannelMessage> getMessagesForChannel(Long channelId) {
        return channelMessageRepository.findAllByChannelId(channelId);
    }
}
