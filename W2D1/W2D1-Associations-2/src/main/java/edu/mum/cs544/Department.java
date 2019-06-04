package edu.mum.cs544;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.OneToMany;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Department extends AbstractEntity {
	private String name;
	
	@Setter(AccessLevel.NONE)
	@OneToMany(mappedBy="department")
	private Set<Employee> employees = new HashSet<>();
	
}
