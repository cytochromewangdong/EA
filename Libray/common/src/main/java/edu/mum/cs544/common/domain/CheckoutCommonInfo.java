package edu.mum.cs544.common.domain;

import java.time.LocalDateTime;

import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;

import edu.mum.cs544.common.domain.base.DefaultPrimaryKeyEntity;
import lombok.Getter;
import lombok.Setter;

@MappedSuperclass
@Getter
@Setter
public abstract class CheckoutCommonInfo extends DefaultPrimaryKeyEntity {

	private LocalDateTime checkoutDate;

	private LocalDateTime dueDate;

	@ManyToOne
	private Member member;

}