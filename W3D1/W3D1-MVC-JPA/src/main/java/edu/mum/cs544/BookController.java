package edu.mum.cs544;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/books")
public class BookController {
	@Resource
	private BookService bookService;

	@GetMapping
	public String getAll(Model model) {
		model.addAttribute("books", bookService.getAll());
		return "bookList";
	}

	@PostMapping
	public String add(Book book) {
		bookService.add(book);
		return "redirect:/books";
	}

	@GetMapping("/add")
	public String viewAdd(@ModelAttribute Car car, Model model) {
		model.addAttribute("msg", "Add");
		return "bookDetail";
	}

	@GetMapping("/{id}")
	public String get(@PathVariable int id, Model model) {
		model.addAttribute("book", bookService.get(id));
		model.addAttribute("msg", "Update");
		return "bookDetail";
	}

	@PostMapping("/{id}")
	public String update(Book book, @PathVariable int id) {
		bookService.update(book);
		return "redirect:/books";
	}

	@PostMapping(value = "/delete")
	public String delete(int bookId) {
		bookService.delete(bookId);
		return "redirect:/books";
	}
}
