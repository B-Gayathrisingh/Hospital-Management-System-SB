package com.example.hospital.controller;

import com.example.hospital.entity.*;
import com.example.hospital.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class HospitalController {

    @Autowired private PatientRepository patientRepo;
    @Autowired private DoctorRepository doctorRepo;
    @Autowired private AppointmentRepository appointmentRepo;
    @Autowired private MedicalRecordRepository recordRepo;

    // Patient
    @PostMapping("/patients")
    public Patient addPatient(@RequestBody Patient p) {
        return patientRepo.save(p);
    }

    @GetMapping("/patients")
    public List<Patient> getPatients() {
        return patientRepo.findAll();
    }

    // Doctor
    @PostMapping("/doctors")
    public Doctor addDoctor(@RequestBody Doctor d) {
        return doctorRepo.save(d);
    }

    @GetMapping("/doctors")
    public List<Doctor> getDoctors() {
        return doctorRepo.findAll();
    }

    // Appointment
    @PostMapping("/appointments")
    public Appointment addAppointment(@RequestBody Appointment a) {
        return appointmentRepo.save(a);
    }

    @GetMapping("/appointments")
    public List<Appointment> getAppointments() {
        return appointmentRepo.findAll();
    }

    // Medical Record
    @PostMapping("/medical-records")
    public MedicalRecord addRecord(@RequestBody MedicalRecord m) {
        return recordRepo.save(m);
    }

    @GetMapping("/patients/{id}/records")
    public List<MedicalRecord> getPatientRecords(@PathVariable Long id) {
        Patient p = patientRepo.findById(id).orElse(null);
        return (p != null) ? p.getRecords() : null;
    }
}
