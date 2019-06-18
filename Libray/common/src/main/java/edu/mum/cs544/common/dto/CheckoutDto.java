package edu.mum.cs544.common.dto;

import java.time.LocalDateTime;

import edu.mum.cs544.common.dto.base.BaseDto;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class CheckoutDto extends BaseDto {

	private LocalDateTime dueDate;
}
