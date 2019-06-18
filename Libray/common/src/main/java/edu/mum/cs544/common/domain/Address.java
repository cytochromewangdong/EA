package edu.mum.cs544.common.domain;

import javax.persistence.Embeddable;

import lombok.Data;

@Embeddable
@Data
public class Address{
	private String city;
	private String state;
	private String street;
	private String zipcode;
}
