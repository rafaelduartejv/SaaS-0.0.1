package com.example.auth.services;

import com.example.auth.domain.reading.ReadingPlan;
import com.example.auth.domain.reading.ReadingPlanDay;
import com.example.auth.domain.user.User;
import com.example.auth.repositories.ReadingPlanDayRepository;
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
    private final ReadingPlanDayRepository readingPlanDayRepository;


    public List<ReadingPlan> getAllReadingPlans() {
        return readingPlanRepository.findAll();
    }

    public List<ReadingPlan> getUserReadingPlans(User user) {
        return readingPlanRepository.findByUser(user);
    }

    public ReadingPlan createReadingPlan(ReadingPlan readingPlan) {
        return readingPlanRepository.save(readingPlan);
    }

    public ReadingPlanDay addDayToReadingPlan(Long readingPlanId, ReadingPlanDay day, User user) {
        ReadingPlan readingPlan = readingPlanRepository.findById(readingPlanId)
                .orElseThrow(() -> new RuntimeException("Reading Plan not found"));

        if (!readingPlan.getUser().equals(user)) {
            throw new RuntimeException("You do not have permission to modify this reading plan");
        }

        day.setReadingPlan(readingPlan);
        return readingPlanDayRepository.save(day);
    }
}