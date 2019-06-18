package edu.mum.cs544.dto;

import edu.mum.cs544.dto.base.DataListPart;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ListResultDto<T> extends SimpleResultDto<DataListPart<T>> {

	public ListResultDto(DataListPart<T> data) {
		super(data);
	}

}
