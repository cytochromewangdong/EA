package edu.mum.cs544.common.domain;

import javax.persistence.Entity;
import javax.persistence.OneToOne;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class CheckoutEntry extends CheckoutCommonInfo {

	@OneToOne
	private BookCopy bookCopy;
}
