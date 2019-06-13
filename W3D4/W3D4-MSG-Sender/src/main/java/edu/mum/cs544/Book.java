package edu.mum.cs544;

import java.io.Serializable;
import java.time.LocalDate;

import lombok.Data;

@Data
public class Book implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -2648752026436279554L;

	private Integer id;

	private String title;

	private String isbn;

	private String author;

	private double price;
	
	private LocalDate publishDate;
}
