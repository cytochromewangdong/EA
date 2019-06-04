package edu.mum.cs544;

import javax.persistence.Entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Publisher extends AbstractEntity {
	private String name;
}
