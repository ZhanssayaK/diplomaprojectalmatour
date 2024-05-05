package com.example.diploma.project.almatour.service;

import com.example.diploma.project.almatour.dto.CreateChannelDTO;
import com.example.diploma.project.almatour.model.Accommodation;
import com.example.diploma.project.almatour.model.Channel;
import com.example.diploma.project.almatour.model.User;
import com.example.diploma.project.almatour.repository.AccomodationRepository;
import com.example.diploma.project.almatour.repository.ChannelRepository;
import com.example.diploma.project.almatour.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ChannelService {

    private final ChannelRepository channelRepository;
    private final UserRepository userRepository;
    private final AccomodationRepository accomodationRepository;

    public Channel createChannelForTour(CreateChannelDTO body) {
        Accommodation accommodation = accomodationRepository.findById(body.getAccomodationId())
                .orElseThrow(() -> new IllegalArgumentException("Tour not found"));
        Channel channel = new Channel();
        channel.setName(body.getChannelName());
        channel.setAccommodation(accommodation);

        List<User> users = userRepository.findAllByAccommodationId(body.getAccomodationId());
        users.add(accommodation.getUser());
        channel.setParticipants(new HashSet<>(users));

        return channelRepository.save(channel);
    }

    public List<Channel> getChatsForUser(Long userId) {
        return channelRepository.findAllByParticipantId(userId);
    }
}
