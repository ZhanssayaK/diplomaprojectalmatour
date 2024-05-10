package com.example.diploma.project.almatour.service;

import com.example.diploma.project.almatour.model.Role;
import com.example.diploma.project.almatour.model.User;
import com.example.diploma.project.almatour.repository.RoleRepository;
import com.example.diploma.project.almatour.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class RegistrationService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationService authenticationService;

    public Boolean registerUser(String email, String password, String rePassword, String fullName){
        User user = userRepository.findByEmail(email);
        if (user == null){
            if (password.equals(rePassword)){

                Role role = roleRepository.findByName("ROLE_USER");
                List<Role> roles = new ArrayList<>();
                roles.add(role);

                User newUser = new User();
                newUser.setEmail(email);
                newUser.setPassword(passwordEncoder.encode(password));
                newUser.setFullName(fullName);
                newUser.setRoles(roles);
//                newUser.setBlocked(false);
                newUser.setAvatarUrl("defaultuser.jpg");
                userRepository.save(newUser);
                return true;
            }
            return false;
        }
        return null;
    }

    public Boolean updatePassword(String oldPassword, String newPassword, String repeatNewPassword) {
        User currentUser = authenticationService.getCurrentUser();

        if(currentUser != null){
            if(passwordEncoder.matches(oldPassword, currentUser.getPassword())){
                if(newPassword.equals(repeatNewPassword)){
                    currentUser.setPassword(passwordEncoder.encode(newPassword));
                    userRepository.save(currentUser);
                    return true;
                }
                return false;
            }
            return null;
        }
        return null;
    }
}
