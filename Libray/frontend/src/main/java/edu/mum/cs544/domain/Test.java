package edu.mum.cs544.domain;

import javax.persistence.Entity;

import edu.mum.cs544.common.domain.base.DefaultPrimaryKeyEntity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Test extends DefaultPrimaryKeyEntity{
	public Test(String test) {
		super();
		this.test = test;
	}

	private String test;
}
