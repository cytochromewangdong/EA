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
		return bookDao.findAll();
	}

	public void add(Book book) {
		bookDao.save(book);
	}

	public Book get(int id) {
		return bookDao.findById(id).get();
//		return bookDao.getOne(id);
	}

	public void update(Book book) {
		bookDao.save(book);
	}

	public void delete(int id) {
		bookDao.deleteById(id);
	}
}
