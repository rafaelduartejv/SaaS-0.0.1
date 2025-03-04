package com.example.auth.domain.reading;

import jakarta.persistence.*;


import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class ReadingPlanDay {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate date;
    private String content;
    private String notes;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "reading_plan_id")
    private ReadingPlan readingPlan;
}

