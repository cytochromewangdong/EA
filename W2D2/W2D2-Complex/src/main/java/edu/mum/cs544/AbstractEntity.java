package edu.mum.cs544;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@EqualsAndHashCode(of = "id")
@MappedSuperclass
@Getter
@Setter
public class AbstractEntity {
	@Id
	@GeneratedValue
	private Long id;
}
