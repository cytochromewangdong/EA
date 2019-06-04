package edu.mum.cs544;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Office {
	@Id
	private String roomnumber;
	
	private String building;

	@OneToMany(mappedBy="office")
	private List<Employee> employees = new ArrayList<>();
}
