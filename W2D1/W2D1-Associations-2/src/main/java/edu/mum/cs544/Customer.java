package edu.mum.cs544;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Customer extends AbstractEntity {
	private String name;

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "customer_Id")
	@Setter(AccessLevel.NONE)
	private List<Reservation> reservations = new ArrayList<>();

	public void addReservation(Reservation rv) {
		this.reservations.add(rv);
	}
}
