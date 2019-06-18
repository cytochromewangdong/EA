package edu.mum.cs544.domain;

import javax.persistence.Column;
import javax.persistence.Entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import edu.mum.cs544.common.domain.base.DefaultPrimaryKeyEntity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public  class SystemUser extends DefaultPrimaryKeyEntity {
	@Column(unique = true)
	private String username;

	@JsonProperty(access=Access.WRITE_ONLY)
	private String password;

}
