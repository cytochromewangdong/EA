package edu.mum.cs544;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Reservation extends AbstractEntity {

	private Date date;
	
	@ManyToOne
	private Book book;
}
