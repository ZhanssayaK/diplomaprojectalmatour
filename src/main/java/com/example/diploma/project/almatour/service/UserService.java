package com.example.diploma.project.almatour.service;

import com.example.diploma.project.almatour.dto.UserDTO;
import com.example.diploma.project.almatour.mapper.UserMapper;
import com.example.diploma.project.almatour.model.User;
import com.example.diploma.project.almatour.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

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
}
