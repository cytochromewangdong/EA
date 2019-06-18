package edu.mum.cs544.common.domain;

import javax.persistence.Entity;
import javax.persistence.NamedAttributeNode;
import javax.persistence.NamedEntityGraph;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
//@NamedEntityGraph(name = "Staff.findById", attributeNodes = @NamedAttributeNode("roleList"))
public class Staff extends LoginUser {

}
