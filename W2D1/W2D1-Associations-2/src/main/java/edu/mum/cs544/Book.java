package edu.mum.cs544;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;

import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
public class Book {
	@Id
	private String isbn;
	private String title;
	private String author;
	
	@ManyToOne
	@JoinTable(name="book_publisher")
	private Publisher publisher;
}
