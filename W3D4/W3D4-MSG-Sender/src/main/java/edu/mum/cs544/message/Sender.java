package edu.mum.cs544.message;

import java.time.LocalDate;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import edu.mum.cs544.Book;

@Component
public class Sender implements CommandLineRunner {
	@Autowired
	private RabbitTemplate template;
	@Autowired
	private Env env;

	@Override
	public void run(String... args) throws Exception {
		// String queue = "hello";
		// String msg = "Hello World!";
		// Person msg = new Person("Frank");
		Book msg = new Book();
		msg.setAuthor("Dong Wang from MSG2222");
		 msg.setId(1);
		msg.setIsbn("978-0-306-40615-7");
		msg.setPrice(15.8);
		msg.setPublishDate(LocalDate.now().minusDays(210));
		msg.setTitle("This is atest from MSG");
//		template.convertAndSend(env.getQueueName(), msg);
//		System.out.println("Sent: " + msg + " to: " + env.getQueueName());
//		template.convertAndSend(env.getQueueName(), 1);
		template.convertAndSend(env.getQueueName(), msg, m->{
			m.getMessageProperties().getHeaders().put("operation", "a");
			return m;
		});
	}
}
