package edu.mum.cs544.common.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import edu.mum.cs544.common.domain.base.DefaultPrimaryKeyEntity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class BookCopy extends DefaultPrimaryKeyEntity {

	@OneToOne(cascade = CascadeType.ALL, mappedBy = "bookCopy")
	private CheckoutEntry checkoutEntry;

	@Column(unique = true)
	private String guid;

	@ManyToOne
	private Book book;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "bookCopy")
	private List<CheckoutEntryHistory> checkoutEntryHistoryList = new ArrayList<>();

}
