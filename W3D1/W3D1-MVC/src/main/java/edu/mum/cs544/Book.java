package edu.mum.cs544;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class Book {
	@Id
	@GeneratedValue
	private Integer id;
	private String title;
	private String isbn;
	private String author;
	private double price;
}
