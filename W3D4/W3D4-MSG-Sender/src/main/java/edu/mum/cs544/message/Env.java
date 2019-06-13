package edu.mum.cs544.message;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import lombok.Getter;


@Component
public class Env {
	
	@Value("${QUEQUE_NAME:book}")
	@Getter
	private String queueName;

}
