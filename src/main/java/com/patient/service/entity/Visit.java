package com.patient.service.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity
public class Visit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDateTime visitDateTime;

    // Getter, setters, and other annotations

    @ManyToOne
    @JoinColumn(name = "patient_id")
    private Patient patient;

    @ManyToMany
    private List<Disease> diseases;

    @ManyToMany
    private List<Doctor> doctors;
}

