package edu.mum.cs544;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues = { "book" })
public class BookListener {

	@Autowired
	private BookService bookService;

//	@RabbitHandler
//	public void add(Book book) {
//		try {
//			if (book.getId() == null) {
//				bookService.add(book);
//			} else {
//				bookService.update(book);
//			}
//
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//
//	}

	@RabbitHandler
	public void save(Book book, @Header("operation") String operation) {
		try {
			if ("a".equalsIgnoreCase(operation)) {
				bookService.add(book);
			} else {
				bookService.update(book);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@RabbitHandler
	public void delete(Integer id) {
		bookService.delete(id);
	}
}
