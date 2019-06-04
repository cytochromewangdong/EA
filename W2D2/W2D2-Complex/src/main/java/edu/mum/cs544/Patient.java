package edu.mum.cs544;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.SecondaryTable;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@SecondaryTable(name = "address", pkJoinColumns = {
		@PrimaryKeyJoinColumn(name = "PATIENT_ID", referencedColumnName = "ID") })
public class Patient extends AbstractEntity {
	private String name;
	@Column(table = "address")
	private String street;
	@Column(table = "address")
	private String zip;
	@Column(table = "address")
	private String city;
}
