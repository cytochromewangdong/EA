package edu.mum.cs544;

import java.net.URI;
import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class Client implements CommandLineRunner {

	@Autowired
	private RestTemplate restTemplate;
	private String localUrl = "http://localhost:8080/rest/books/";

	@Override
	public void run(String... args) throws Exception {
		// make a call to whatever url you mapped getAll() on and print the result
		List<Book> bookList = restTemplate
				.exchange(localUrl, HttpMethod.GET, null, new ParameterizedTypeReference<List<Book>>() {
				}).getBody();
		System.out.println(bookList);
		// make a call to the url that you mapped add() on (giving it a new book)
		Book book = new Book();
		book.setAuthor("Restful Author");
		book.setIsbn("978-0-306-40615-7");
		book.setPrice(128.8);
		book.setPublishDate(LocalDate.now().minusDays(2));
		book.setTitle("Restful Title");
		URI url = restTemplate.postForLocation(localUrl, book);
		Book result = restTemplate.getForObject(url, Book.class);
		System.out.println(result);
		// make a call to the url that you mapped update() on (giving it an updated
		// version)
		result.setAuthor("Changed Author");
		restTemplate.put(localUrl, result);
		// make a call to the url that you mapped delete() on (deleting one of the
		// books)
		restTemplate.delete(localUrl + "1");
		// make a call to the url that you mapped getAll() on and print the result again
		bookList = restTemplate.exchange(localUrl, HttpMethod.GET, null, new ParameterizedTypeReference<List<Book>>() {
		}).getBody();
		System.out.println(bookList);
		// make a call to the url that you mapped get() to check that you can get one
		// book
		Book fetchedBook = restTemplate.getForObject(localUrl + "{id}", Book.class, 2);
		System.out.println(fetchedBook);
	}

}
