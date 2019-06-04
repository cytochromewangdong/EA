package edu.mum.cs544;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Laptop extends AbstractEntity {

	private String brand;
	private String type;
	
	@ManyToOne
	private Employee employee;
}
