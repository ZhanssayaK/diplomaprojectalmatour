package com.example.diploma.project.almatour.api;

import com.example.diploma.project.almatour.dto.UserDTO;
import com.example.diploma.project.almatour.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

//    @GetMapping(value = "{id}/getByRoleId")
//    public List<UserDTO> getUserByRoleId(@PathVariable Long id){
//        List<UserDTO> users = userService.getUserByRoleId(id);
//        return users;
//    }
}
