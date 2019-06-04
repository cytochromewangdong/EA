package edu.mum.cs544;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Appointment extends AbstractEntity {

	private String appdate;
	@OneToOne
	@JoinColumn(name = "PATIENT")
	private Patient patient;
	@Embedded
	private Payment payment;
	@OneToOne
	@JoinColumn(name = "DOCTOR")
	private Doctor doctor;
}
