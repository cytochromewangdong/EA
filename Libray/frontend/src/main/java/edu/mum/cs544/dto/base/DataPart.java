package edu.mum.cs544.dto.base;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DataPart<T> {

	public DataPart(List<T> items, long totalCount) {
		super();
		this.items = items;
		this.totalCount = totalCount;
	}

	private List<T> items;

	@JsonProperty("total_count")
	private long totalCount;
}
