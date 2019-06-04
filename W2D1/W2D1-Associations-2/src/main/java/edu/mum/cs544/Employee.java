package edu.mum.cs544;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@EqualsAndHashCode(of = "employeenumber")
public class Employee {
	@Id
	private Long employeenumber;
	private String name;
	
	@ManyToOne
	private Department department;
	
	@ManyToOne
	private Office office;
	
	
	public void register(Department dpt,Office office)
	{
		dpt.getEmployees().add(this);
		office.getEmployees().add(this);
		this.setDepartment(dpt);
		this.setOffice(office);
	}
	

}
