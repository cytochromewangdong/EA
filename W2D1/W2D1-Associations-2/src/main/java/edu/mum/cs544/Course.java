package edu.mum.cs544;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Course extends AbstractEntity {
	private String coursenumber;
	private String name;

	@ManyToMany(mappedBy = "courses")
	@Setter(AccessLevel.NONE)
	private List<Student> students = new ArrayList<>();
}
