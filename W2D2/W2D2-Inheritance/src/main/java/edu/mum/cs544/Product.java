package edu.mum.cs544;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Lob;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
//@DiscriminatorColumn(name="ptype")
public class Product extends AbstractEntity {
	private String name;
	@Lob
	private String description;
}
