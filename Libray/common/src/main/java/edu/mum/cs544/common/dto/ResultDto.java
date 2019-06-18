package edu.mum.cs544.common.dto;

import edu.mum.cs544.common.dto.base.BaseDto;

public class ResultDto extends BaseDto {
	public ResultDto(boolean b) {
		super(b);
	}

	public ResultDto() {

	}

	public static ResultDto DEFAULT_FAIL_RESULT = new ResultDto(false);
	public static ResultDto DEFAULT_OK_RESULT = new ResultDto(true);
}
