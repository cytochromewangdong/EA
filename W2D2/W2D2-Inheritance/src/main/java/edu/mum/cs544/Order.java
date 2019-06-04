package edu.mum.cs544;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import lombok.Getter;
import lombok.Setter;

@Entity(name = "TOrder")
@Getter
@Setter
public class Order {
	@Id
	@GeneratedValue
	private Long orderid;

	private Date date;

	@ManyToOne
	private Customer customer;

	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn
	private List<OrderLine> orderLines = new ArrayList<>();
}
