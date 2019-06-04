package edu.mum.cs544;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import lombok.Getter;
import lombok.Setter;

@Entity
//@DiscriminatorValue("cd")
@Getter
@Setter
public class Cd extends Product {
	private String artist;
}
