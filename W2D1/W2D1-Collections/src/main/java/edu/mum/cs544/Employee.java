package edu.mum.cs544;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Employee extends AbstractEntity {

	private String firstname;
	private String lastname;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "employee")
	@Setter(AccessLevel.NONE)
	private Set<Laptop> laotopSet = new HashSet<>();

	public boolean add(Laptop laptop) {
		if (!laotopSet.contains(laptop)) {
			laptop.setEmployee(this);
			return laotopSet.add(laptop);
		}
		return false;
	}

	public boolean remove(Laptop laptop) {
		if (laotopSet.contains(laptop)) {
			laptop.setEmployee(null);
			return laotopSet.remove(laptop);
		}
		return false;
	}
}
