package edu.mum.cs544.dto;

import edu.mum.cs544.common.dto.base.BaseDto;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SimpleResultDto<T> extends BaseDto {
	public SimpleResultDto(T data) {
		super(data != null);
		this.data = data;
	}

	private T data;
}
