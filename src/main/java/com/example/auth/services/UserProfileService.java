package com.example.auth.services;

import com.example.auth.domain.user.UserProfile;
import com.example.auth.repositories.UserProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserProfileService {
    @Autowired
    private UserProfileRepository userProfileRepository;

    public Optional<UserProfile> getProfileByUserId(String userId) {
        return userProfileRepository.findByUserId(userId);
    }

    public UserProfile updateProfile(UserProfile profile) {
        return userProfileRepository.save(profile);
    }
}
