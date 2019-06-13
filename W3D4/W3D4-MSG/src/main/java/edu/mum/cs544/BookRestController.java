package edu.mum.cs544;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.view.RedirectView;

@RestController
@RequestMapping("/rest/books/")
public class BookRestController {

	@Resource
	private BookService bookService;

	@GetMapping("/")
	public List<Book> getAll() {
		return bookService.getAll();
	}

	@GetMapping("/{id}")
	public Book get(@PathVariable int id) {
		return bookService.get(id);
	}

	@PostMapping("/")
	public RedirectView add(@RequestBody Book book) {
		bookService.add(book);
		return new RedirectView("/rest/books/" + book.getId());
	}

	@PutMapping("/")
	public void update(@RequestBody Book book) {
		bookService.update(book);
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable int id) {
		bookService.delete(id);
	}
}
