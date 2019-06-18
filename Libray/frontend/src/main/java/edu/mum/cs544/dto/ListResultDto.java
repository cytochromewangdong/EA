package edu.mum.cs544.dto;

import edu.mum.cs544.dto.base.DataPart;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ListResultDto<T> extends SimpleResultDto<DataPart<T>> {

	public ListResultDto(DataPart<T> data) {
		super(data);
	}

}
