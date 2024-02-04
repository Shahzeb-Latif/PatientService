package com.patient.service.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private int age;
    private String gender;
    private String phoneNumber;
    private String address;

    // Getter, setters, and other annotations

    @OneToMany(mappedBy = "patient")
    private List<Visit> visits;
}