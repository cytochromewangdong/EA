package edu.mum.cs544;

import javax.persistence.Column;
import javax.persistence.Entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Doctor extends AbstractEntity {
	@Column(name = "TYPE")
	private String doctortype;
	private String firstname;
	private String lastname;
}
