package edu.mum.cs544.common.dto.base;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class BaseDto {
	public BaseDto(boolean result, String message) {
		super();
		this.result = result;
		this.message = message;
	}
	public BaseDto() {
		
	}
	public BaseDto(boolean result) {
		this(result, null);
	}
	private boolean result = true;
	private String message;

}
