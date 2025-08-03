package com.example.hospital.entity;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
public class MedicalRecord {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String diagnosis;
    private String treatment;
    private LocalDate date;

    @ManyToOne
    @JoinColumn(name = "patient_id")
    private Patient patient;

	public Long getId() {
		return id;
	}

	public String getDiagnosis() {
		return diagnosis;
	}

	public String getTreatment() {
		return treatment;
	}

	public LocalDate getDate() {
		return date;
	}

	public Patient getPatient() {
		return patient;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setDiagnosis(String diagnosis) {
		this.diagnosis = diagnosis;
	}

	public void setTreatment(String treatment) {
		this.treatment = treatment;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}

   
}
