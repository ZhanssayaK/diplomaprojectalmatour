package com.example.diploma.project.almatour.service;

import com.example.diploma.project.almatour.dto.MessageDTO;
import com.example.diploma.project.almatour.dto.UserDTO;
import com.example.diploma.project.almatour.dto.UserMessagesDTO;
import com.example.diploma.project.almatour.mapper.MessageMapper;
import com.example.diploma.project.almatour.mapper.UserMapper;
import com.example.diploma.project.almatour.mapper.UserMessagesMapper;
import com.example.diploma.project.almatour.model.User;
import com.example.diploma.project.almatour.repository.MessageRepository;
import com.example.diploma.project.almatour.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final MessageRepository messageRepository;
    private final MessageMapper messageMapper;
    private final UserMessagesMapper userMessagesMapper;

    public List<UserDTO> getUsers(){
        List<UserDTO> userDTOS = new ArrayList<>();
        List<User> usersList = userRepository.findAll();
        for (User user:usersList) {
            userDTOS.add(userMapper.toDto(user));
        }
        return userDTOS;
    }

    public UserDTO getUserById(Long id) {
        return userMapper.toDto(userRepository.findById(id).orElse(null));
    }
    public UserMessagesDTO getUserMessageById(Long id){return userMessagesMapper.toDto(userRepository.findById(id).orElse(null));}

    public void deleteUser(Long id){
        userRepository.deleteById(id);
    }

    public UserDTO blockUser(Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("USER NOT FOUND!"));
        user.setBlocked(true);
        User updatedUser = userRepository.save(user);

        return userMapper.toDto(updatedUser);
    }

    public List<UserMessagesDTO> getUsersWhoMessagedCurrentUser(Long currentUserId) {
        // Получить список сообщений, адресованных текущему пользователю
        List<MessageDTO> messagesToCurrentUser = messageMapper.toDtoList(messageRepository.findAllByReceiverId(currentUserId));

        // Получить уникальные идентификаторы отправителей
        List<Long> senderIds = messagesToCurrentUser.stream()
                .map(MessageDTO::getSenderId)
                .filter(senderId -> !senderId.equals(currentUserId)) // Исключить текущего пользователя
                .distinct()
                .collect(Collectors.toList());

        // Получить информацию о пользователях, отправивших сообщения
        return userMessagesMapper.toDtoList(userRepository.findAllById(senderIds));
    }
}
