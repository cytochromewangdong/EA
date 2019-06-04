package edu.mum.cs544;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class OrderLine extends AbstractEntity {
	private double quantity;
	
	@ManyToOne
	private Product product;
}
