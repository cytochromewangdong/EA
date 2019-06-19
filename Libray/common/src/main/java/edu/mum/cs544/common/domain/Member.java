package edu.mum.cs544.common.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import edu.mum.cs544.common.domain.base.DefaultPrimaryKeyEntity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Member extends DefaultPrimaryKeyEntity {

	@Column(unique = true)
	private String memberId;

	private String phonenumber;
	private String firstname;
	private String lastname;
	@JsonProperty("addressData")
	private Address personAddress;
	private String email;
	@JsonIgnore
	@OneToMany(mappedBy = "member")
	private List<CheckoutEntry> checkoutEntryList = new ArrayList<>();

	@JsonIgnore
	@OneToMany(mappedBy = "member")
	private List<CheckoutEntryHistory> checkoutEntryHistoryList = new ArrayList<>();
}
