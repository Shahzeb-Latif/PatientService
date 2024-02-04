package com.patient.service.repository;

import com.patient.service.entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface PatientRepository extends JpaRepository<Patient, Long> {
    List<Patient> findByAge(int age);
    List<Patient> findByGender(String gender);
}