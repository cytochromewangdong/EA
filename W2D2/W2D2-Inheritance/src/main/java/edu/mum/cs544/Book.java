package edu.mum.cs544;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import lombok.Getter;
import lombok.Setter;

@Entity
//@DiscriminatorValue("book")
@Getter
@Setter
public class Book extends Product{
	private String title;
}
