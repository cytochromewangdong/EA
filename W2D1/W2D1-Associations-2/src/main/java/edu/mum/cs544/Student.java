package edu.mum.cs544;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@EqualsAndHashCode(of = "studentid")
public class Student {
	@Id
	private Long studentid;
	private String firstname;
	private String lastname;
	
	@ManyToMany
	@Setter(AccessLevel.NONE)
	private List<Course> courses = new ArrayList<>();
	
	public void addCourse(Course course)
	{
		courses.add(course);
		course.getStudents().add(this);
	}
	
	public void removeCourse(Course course) {
		courses.remove(course);
		course.getStudents().remove(this);
	}
}
