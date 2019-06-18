package edu.mum.cs544.common.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;

import edu.mum.cs544.common.domain.base.DefaultPrimaryKeyEntity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Author extends DefaultPrimaryKeyEntity {
	private String firstName;
	private String lastName;
	private String phoneNumber;
	@Embedded
	private Address personAddress;

	private String credentials;
	private String shortBio;

	@ManyToMany(mappedBy = "authorList")
	private List<Book> bookList = new ArrayList<>();
}
