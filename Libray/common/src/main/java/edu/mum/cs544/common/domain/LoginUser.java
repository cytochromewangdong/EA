package edu.mum.cs544.common.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToMany;
import javax.persistence.Version;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import edu.mum.cs544.common.domain.base.DefaultPrimaryKeyEntity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Getter
@Setter
public abstract class LoginUser extends DefaultPrimaryKeyEntity {
	@Column(unique = true)
	@JsonProperty("email")
	private String username;

	@JsonProperty(access=Access.WRITE_ONLY)
	private String password;

	
	private String firstname;
	private String lastname;
	private String phoneNumber;
	private Address personAddress;

	@ManyToMany
	@JsonProperty("roles")
	private List<Role> roleList = new ArrayList<>();

	@Version
	private int version;
}
