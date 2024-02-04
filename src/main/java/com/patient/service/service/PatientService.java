package com.patient.service.service;

import com.patient.service.entity.Patient;
import com.patient.service.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientService {
    @Autowired
    private PatientRepository patientRepository;

    public List<Patient> getAllPatients() {
        return patientRepository.findAll();
    }

    public Patient getPatientById(Long id) {
        return patientRepository.findById(id).orElse(null);
    }

    public List<Patient> getPatientsByAge(int age) {
        return patientRepository.findByAge(age);
    }

    public List<Patient> getPatientsByGender(String gender) {
        return patientRepository.findByGender(gender);
    }

    public Patient savePatient(Patient patient) {
        return patientRepository.save(patient);
    }

    public void updatePatient(Long id, Patient updatedPatient) {
        Patient existingPatient = patientRepository.findById(id).orElse(null);
        if (existingPatient != null) {
            // Update patient fields
            existingPatient.setName(updatedPatient.getName());
            existingPatient.setAge(updatedPatient.getAge());
            existingPatient.setGender(updatedPatient.getGender());
            existingPatient.setPhoneNumber(updatedPatient.getPhoneNumber());
            existingPatient.setAddress(updatedPatient.getAddress());

            // Save the updated patient
            patientRepository.save(existingPatient);
        }
    }

    public void deletePatient(Long id) {
        patientRepository.deleteById(id);
    }
}
