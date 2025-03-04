package com.example.auth.controllers;

import com.example.auth.domain.user.User;
import com.example.auth.domain.user.UserProfile;
import com.example.auth.repositories.UserRepository;
import com.example.auth.services.UserProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/users")
public class UserProfileController {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserProfileService userProfileService;

    @GetMapping("/{id}")
    public Optional<UserProfile> getUserProfile(@PathVariable String id) {
        return userProfileService.getProfileByUserId(id);
    }

    @PutMapping("/{id}")
    public UserProfile updateUserProfile(@PathVariable String id, @RequestBody UserProfile profile) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));

        profile.setUser(user);
        return userProfileService.updateProfile(profile);
    }

}
