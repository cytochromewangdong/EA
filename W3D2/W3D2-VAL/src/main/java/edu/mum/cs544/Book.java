package edu.mum.cs544;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Past;
import javax.validation.constraints.Positive;

import org.hibernate.validator.constraints.ISBN;
import org.hibernate.validator.constraints.SafeHtml;
import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
@Entity
public class Book {
	@Id
	@GeneratedValue
	private Integer id;
	@NotBlank
	@SafeHtml
	private String title;
	@ISBN
	private String isbn;
	@NotBlank
	@SafeHtml
	private String author;
	@Positive
	private double price;
	
	@Past
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate publishDate;
}
