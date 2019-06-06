package edu.mum.cs544;

import java.util.HashMap;
import java.util.Map;

import javax.persistence.EntityGraph;

public class StudentDAO {

	// private Collection<Student> studentlist = new ArrayList<Student>();

	public StudentDAO() {
		// Student student = new Student(12345, "Frank", "Brown");
		// Course course1 = new Course(1101, "Java", "A");
		// Course course2 = new Course(1102, "Math", "B-");
		// student.addCourse(course1);
		// student.addCourse(course2);
		// studentlist.add(student);

	}

	public Student load(long studentid) {
		Map<String, Object> prop = new HashMap<>();
		EntityGraph<Student> eg = EntityManagerHelper.getCurrent().createEntityGraph(Student.class);
		eg.addAttributeNodes("courselist");
		prop.put("javax.persistence.fetchgraph", eg);
		return EntityManagerHelper.getCurrent().find(Student.class, studentid, prop);
//		return EntityManagerHelper.getCurrent().find(Student.class, studentid);
//		return EntityManagerHelper.getCurrent().getReference(Student.class, studentid);
	}
}
