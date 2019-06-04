package edu.mum.cs544;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Student {
	@Id
	private Long studentid;
	private String firstname;
	private String lastname;
}
