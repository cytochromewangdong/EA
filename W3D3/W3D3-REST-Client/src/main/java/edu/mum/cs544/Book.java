package edu.mum.cs544;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Data
public class Book {

	private Integer id;

	private String title;

	private String isbn;

	private String author;

	private double price;
//	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
	private LocalDate publishDate;
}
