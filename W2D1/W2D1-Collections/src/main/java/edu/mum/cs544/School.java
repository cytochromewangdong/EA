package edu.mum.cs544;

import java.util.HashMap;
import java.util.Map;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.MapKey;
import javax.persistence.OneToMany;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class School extends AbstractEntity {
	private String name;

	@OneToMany
	@JoinColumn(name = "school_id")
	@MapKey(name = "studentid")
	@Setter(AccessLevel.NONE)
	private Map<Long, Student> students = new HashMap<>();
}
