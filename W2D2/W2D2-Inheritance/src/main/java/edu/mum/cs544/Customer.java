package edu.mum.cs544;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Customer extends AbstractEntity {
	private String firstname;
	private String lastname;

	@OneToMany(mappedBy = "customer")
	@Setter(AccessLevel.NONE)
	private List<Order> orders = new ArrayList<>();
	
	public void addOrder(Order order) {
		this.orders.add(order);
		order.setCustomer(this);
	}
}
