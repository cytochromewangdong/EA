package edu.mum.cs544;

import java.util.List;

import javax.annotation.Resource;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

@Service
@Transactional
public class BookService {
	@Resource
	private IBookDao bookDao;

	public List<Book> getAll() {
		return bookDao.getAll();
	}

	public void add(Book book) {
		bookDao.add(book);
	}

	public Book get(int id) {
		return bookDao.get(id);
	}

	public void update(Book book) {
		bookDao.update(book);
	}

	public void delete(int id) {
		bookDao.delete(id);
	}
}
