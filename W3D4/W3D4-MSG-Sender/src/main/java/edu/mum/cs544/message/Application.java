package edu.mum.cs544.message;

import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Application {
	@Autowired
	private Env env;

	@Bean
	public Queue book() {
		return new Queue(env.getQueueName());
	}

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}
