package com.example.auth.services;

import com.example.auth.domain.reading.ReadingPlan;
import com.example.auth.domain.user.User;
import com.example.auth.repositories.ReadingPlanRepository;
import com.example.auth.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ReadingPlanService {
    private final ReadingPlanRepository readingPlanRepository;
    private final UserRepository userRepository;

    public List<ReadingPlan> getAllReadingPlans() {
        return readingPlanRepository.findAll();
    }

    public List<ReadingPlan> getUserReadingPlans(User user) {
        return readingPlanRepository.findByUser(user);
    }

    public ReadingPlan createReadingPlan(ReadingPlan readingPlan) {
        return readingPlanRepository.save(readingPlan);
    }
}