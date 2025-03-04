package com.example.auth.repositories;

import com.example.auth.domain.reading.ReadingPlanDay;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReadingPlanDayRepository extends JpaRepository<ReadingPlanDay, Long> {
    List<ReadingPlanDay> findByReadingPlanId(Long readingPlanId);
}
