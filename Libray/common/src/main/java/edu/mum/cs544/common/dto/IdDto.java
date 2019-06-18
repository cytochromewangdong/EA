package edu.mum.cs544.common.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class IdDto extends ResultDto {
	private Long id;

	public IdDto(Long id) {
		super(true);
		this.id = id;
	}

	public static IdDto of(long id) {
		return new IdDto(id);
	}
}
