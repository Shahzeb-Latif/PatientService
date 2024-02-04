package com.patient.service.repository;

import com.patient.service.entity.Disease;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DiseaseRepository extends JpaRepository<Disease, Long> {
}
