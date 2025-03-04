package com.example.auth.controllers;

import com.example.auth.domain.reading.ReadingPlanDay;
import com.example.auth.services.ReadingPlanDayService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/reading-plans/{readingPlanId}/days")
public class ReadingPlanDayController {
    private final ReadingPlanDayService readingPlanDayService;

    public ReadingPlanDayController(ReadingPlanDayService readingPlanDayService) {
        this.readingPlanDayService = readingPlanDayService;
    }

    @GetMapping
    public List<ReadingPlanDay> getDaysByReadingPlan(@PathVariable Long readingPlanId) {
        return readingPlanDayService.getDaysByReadingPlan(readingPlanId);
    }

    @PostMapping
    public ReadingPlanDay addDayToReadingPlan(@PathVariable Long readingPlanId, @RequestBody ReadingPlanDay readingPlanDay) {
        return readingPlanDayService.addDayToReadingPlan(readingPlanId, readingPlanDay);
    }
}
