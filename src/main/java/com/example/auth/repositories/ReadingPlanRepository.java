package com.example.auth.repositories;

import com.example.auth.domain.reading.ReadingPlan;
import com.example.auth.domain.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReadingPlanRepository extends JpaRepository<ReadingPlan, Long> {
    List<ReadingPlan> findByUser(User user);
}
