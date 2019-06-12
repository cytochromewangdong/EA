package edu.mum.cs544;

import javax.annotation.Resource;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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

	@PostMapping("/add")
	public String add(@Valid Book book, BindingResult br, RedirectAttributes ra) {
		// if (br.hasErrors()) {
		// return "bookDetail";
		// }
		if (br.hasErrors()) {
			ra.addFlashAttribute(book);
			ra.addFlashAttribute("org.springframework.validation.BindingResult.book", br);
			return "redirect:/books/add";
		}
		bookService.add(book);
		return "redirect:/books";
	}

	@GetMapping("/add")
	public String viewAdd(Model model) {
		// @ModelAttribute Book book
		if (!model.containsAttribute("book")) {
			model.addAttribute(new Book());
		}
		model.addAttribute("msg", "Add");
		return "bookDetail";
	}

	@GetMapping("/{id}")
	public String get(@PathVariable int id, Model model) {
		// model.addAttribute("book", bookService.get(id));
		if (!model.containsAttribute("book")) {
			model.addAttribute("book", bookService.get(id));
		}
		model.addAttribute("msg", "Update");
		return "bookDetail";
	}

	@PostMapping("/{id}")
	public String update(@Valid Book book, BindingResult br, @PathVariable int id, RedirectAttributes ra) {
		if (br.hasErrors()) {
			// return "bookDetail";
			ra.addFlashAttribute("org.springframework.validation.BindingResult.book", br);
			ra.addFlashAttribute("book", book);
			// ra.addAttribute("id", book.getId());
			return "redirect:/books/{id}";
		}
		bookService.update(book);
		return "redirect:/books";
	}

	@PostMapping(value = "/delete")
	public String delete(int bookId) {
		bookService.delete(bookId);
		return "redirect:/books";
	}
}
