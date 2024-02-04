package com.patient.service.controller;

import com.patient.service.entity.Patient;
import com.patient.service.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/patients")
public class PatientController {
    @Autowired
    private PatientService patientService;

    @GetMapping
    public List<Patient> getAllPatients() {
        return patientService.getAllPatients();
    }

    @GetMapping("/{id}")
    public Patient getPatientById(@PathVariable Long id) {
        return patientService.getPatientById(id);
    }

    @GetMapping("/byAge/{age}")
    public List<Patient> getPatientsByAge(@PathVariable int age) {
        return patientService.getPatientsByAge(age);
    }

    @GetMapping("/byGender/{gender}")
    public List<Patient> getPatientsByGender(@PathVariable String gender) {
        return patientService.getPatientsByGender(gender);
    }

    @PostMapping
    public Patient savePatient(@RequestBody Patient patient) {
        return patientService.savePatient(patient);
    }

    @PutMapping("/{id}")
    public void updatePatient(@PathVariable Long id, @RequestBody Patient updatedPatient) {
        patientService.updatePatient(id, updatedPatient);
    }

    @DeleteMapping("/{id}")
    public void deletePatient(@PathVariable Long id) {
        patientService.deletePatient(id);
    }
}
