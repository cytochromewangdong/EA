package edu.mum.cs544;

import javax.persistence.Embeddable;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Embeddable
public class Payment {
	 private String paydate;
	 private double amount;
}
