package com.example.auth.services;

import com.example.auth.domain.reading.ReadingPlan;
import com.example.auth.domain.reading.ReadingPlanDay;
import com.example.auth.repositories.ReadingPlanDayRepository;
import com.example.auth.repositories.ReadingPlanRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReadingPlanDayService {
    private final ReadingPlanDayRepository readingPlanDayRepository;
    private final ReadingPlanRepository readingPlanRepository;

    public ReadingPlanDayService(ReadingPlanDayRepository readingPlanDayRepository, ReadingPlanRepository readingPlanRepository) {
        this.readingPlanDayRepository = readingPlanDayRepository;
        this.readingPlanRepository = readingPlanRepository;
    }

    public List<ReadingPlanDay> getDaysByReadingPlan(Long readingPlanId) {
        return readingPlanDayRepository.findByReadingPlanId(readingPlanId);
    }

    public ReadingPlanDay addDayToReadingPlan(Long readingPlanId, ReadingPlanDay readingPlanDay) {
        Optional<ReadingPlan> readingPlanOpt = readingPlanRepository.findById(readingPlanId);
        if (readingPlanOpt.isEmpty()) {
            throw new RuntimeException("Plano de leitura não encontrado");
        }
        ReadingPlan readingPlan = readingPlanOpt.get();
        readingPlanDay.setReadingPlan(readingPlan);
        return readingPlanDayRepository.save(readingPlanDay);
    }
}
