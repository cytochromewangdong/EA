package edu.mum.cs544;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Flight extends AbstractEntity {

	private String flightnumber;
	@Column(name="_from")
	private String from;
	@Column(name="_to")
	private String to;
	private Date date;

}
