package edu.mum.cs544.common.dto;

import edu.mum.cs544.common.dto.base.BaseDto;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OpenId extends BaseDto {
	private String openId;

	public OpenId(boolean result, String message, String openId) {
		super(result, message);
		this.openId = openId;
	}

	public OpenId() {

	}
}
