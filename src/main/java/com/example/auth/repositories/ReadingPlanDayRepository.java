package com.example.auth.repositories;

import com.example.auth.domain.reading.ReadingPlanDay;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReadingPlanDayRepository extends JpaRepository<ReadingPlanDay, Long> {
}
