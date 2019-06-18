package edu.mum.cs544.common.domain;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class CheckoutEntryHistory extends CheckoutCommonInfo {
//	private double finedAmount;
	
	@ManyToOne
	private BookCopy bookCopy;
}
