package com.example.auth.domain.reading;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name = "reading_plan_days")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
class ReadingPlanDay {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "reading_plan_id", nullable = false)
    private ReadingPlan readingPlan;

    private LocalDate date;

    @Column(columnDefinition = "TEXT")
    private String content;

    @Column(columnDefinition = "TEXT")
    private String notes;
}

