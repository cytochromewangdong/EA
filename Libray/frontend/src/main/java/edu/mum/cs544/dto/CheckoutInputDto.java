package edu.mum.cs544.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CheckoutInputDto {
	private String readerId;
	private String bookId;
}
