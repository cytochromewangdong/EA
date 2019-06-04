package edu.mum.cs544;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OrderColumn;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Passenger extends AbstractEntity {
	private String name;

	@OneToMany
	@Setter(AccessLevel.NONE)
	@JoinColumn(name="passenger_id")
	@OrderColumn(name="seq")
	private List<Flight> flights= new ArrayList<>();
}
