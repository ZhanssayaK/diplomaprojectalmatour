package com.example.diploma.project.almatour.api;

import com.example.diploma.project.almatour.dto.CreditCardDetailsDTO;
import com.example.diploma.project.almatour.dto.UserDTO;
import com.example.diploma.project.almatour.dto.UserMessagesDTO;
import com.example.diploma.project.almatour.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/users")
public class UserController {

    private final UserService userService;

    @GetMapping
    public List<UserDTO> getUsers(){
        return userService.getUsers();
    }

    @DeleteMapping(value = "{id}")
    public void deleteUserById(@PathVariable(name = "id") Long id){
        userService.deleteUser(id);
    }

    @PatchMapping("{id}/block")
    public ResponseEntity<UserDTO> blockUserById(@PathVariable Long id) {
        UserDTO blockedUser = userService.blockUser(id);
        return ResponseEntity.ok(blockedUser);
    }

    @GetMapping(value = "{id}")
    public UserDTO getUserById(@PathVariable(name = "id") Long id){
        return userService.getUserById(id);
    }

    @GetMapping("/{id}/credit-card-details")
    public CreditCardDetailsDTO getCreditCardDetailsByUserId(@PathVariable Long id) {
        UserDTO userDTO = userService.getUserById(id);
        if (userDTO.getCreditCardDetails() == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Credit card details not found for user with id " + id);
        }
        return userDTO.getCreditCardDetails();
    }

    @GetMapping(value = "/allUserMessages/{currentUserId}")
    public List<UserMessagesDTO> getUsersWhoMessagedCurrentUser(@PathVariable(value = "currentUserId") Long currentUserId){
        return userService.getUsersWhoMessagedCurrentUser(currentUserId);
    }

    @GetMapping(value = "/userdetails/{id}")
    public UserMessagesDTO getUserMessageById(@PathVariable(name = "id") Long id){
        return userService.getUserMessageById(id);
    }
}
