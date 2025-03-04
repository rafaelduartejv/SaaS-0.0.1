package com.example.auth.controllers;

import com.example.auth.domain.reading.ReadingPlan;
import com.example.auth.domain.reading.ReadingPlanDay;
import com.example.auth.domain.user.User;
import com.example.auth.repositories.UserRepository;
import com.example.auth.services.ReadingPlanService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/reading-plans")
@RequiredArgsConstructor
public class ReadingPlanController {
    private final ReadingPlanService readingPlanService;
    private final UserRepository userRepository;

    @GetMapping
    public List<ReadingPlan> getAllReadingPlans() {
        return readingPlanService.getAllReadingPlans();
    }

    @GetMapping("/my")
    public List<ReadingPlan> getUserReadingPlans(@AuthenticationPrincipal UserDetails userDetails) {
        User user = userRepository.findByLogin(userDetails.getUsername())
                .orElseThrow(() -> new RuntimeException("User not found"));
        return readingPlanService.getUserReadingPlans(user);
    }

    @PostMapping
    public ReadingPlan createReadingPlan(@RequestBody ReadingPlan readingPlan, @AuthenticationPrincipal UserDetails userDetails) {
        User user = userRepository.findByLogin(userDetails.getUsername())
                .orElseThrow(() -> new RuntimeException("User not found"));
        readingPlan.setUser(user);
        return readingPlanService.createReadingPlan(readingPlan);
    }

    @PostMapping("/{id}/days")
    public ResponseEntity<ReadingPlanDay> addReadingPlanDay(
            @PathVariable Long id,
            @RequestBody ReadingPlanDay day,
            @AuthenticationPrincipal UserDetails userDetails) {

        User user = userRepository.findByLogin(userDetails.getUsername())
                .orElseThrow(() -> new RuntimeException("User not found"));

        ReadingPlanDay savedDay = readingPlanService.addDayToReadingPlan(id, day, user);
        return ResponseEntity.ok(savedDay);
    }
}
