package edu.mum.cs544;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import lombok.Getter;
import lombok.Setter;

@Entity
//@DiscriminatorValue("dvd")
@Getter
@Setter
public class Dvd extends Product{
	private String genre;
}
