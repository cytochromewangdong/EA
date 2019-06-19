package edu.mum.cs544.mock;

import java.util.Arrays;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.mum.cs544.common.domain.Book;
import edu.mum.cs544.common.domain.BookCopy;
import edu.mum.cs544.common.domain.Member;
import edu.mum.cs544.common.domain.Role;
import edu.mum.cs544.common.domain.Staff;
import edu.mum.cs544.common.service.base.BaseService;
import edu.mum.cs544.service.ReaderService;

@Service
@Transactional
public class MockHandler extends BaseService {

	@Autowired
	private ReaderService readerService;
	public void createMockData() {
		// admin
		// lib
		// norm

		// staffRepository.deleteAll();
		// this.roleRepository.deleteAll();
		createStaffAndRole();
		createBook("123", "testBook001");
		createBook("124", "testBook002");
		createBook("125", "testBook003");
		createBook("126", "testBook004");
		Member m = new Member();
		m.setFirstname("Bilegee");
		m.setLastname("Jargalsaikhan");
		m.setEmail("bilgee12.py@gmail.com");
//		m.set
		readerService.add(m);
//	    "firstname":"Bilegee",
//	    "lastname":"Jargalsaikhan",
//	    "email":"bilgee12.py@gmail.com",
//	    "password":"123"
		
	}

	private void createBook(String isbn, String title) {
		Book book = new Book();
		book.setIsbn(isbn);
		book.setLoanDuration(10);
		book.setTitle(title);
		this.bookRepository.save(book);
		for (int i = 0; i < 12; i++) {
			BookCopy bc = new BookCopy();
			bc.setGuid(String.valueOf(book.getId() * 1000 + (i + 1)));
			bc.setBook(book);
			book.getBookCopies().add(bc);
		}
		
	}

	private void createStaffAndRole() {
		Role admin = new Role();
		admin.setRole("admin");
		this.roleRepository.save(admin);
		Role lib = new Role();
		lib.setRole("lib");
		this.roleRepository.save(lib);
		Role norm = new Role();
		norm.setRole("norm");
		this.roleRepository.save(norm);

		Staff lb = new Staff();
		lb.setUsername("lib@1.com");
		lb.setPassword(bCryptPasswordEncoder.encode("123"));
		lb.getRoleList().add(lib);
		this.staffRepository.save(lb);
		Staff adminStaff = new Staff();
		adminStaff.setUsername("admin@1.com");
		adminStaff.setPassword(bCryptPasswordEncoder.encode("123"));
		adminStaff.getRoleList().add(admin);

		this.staffRepository.save(adminStaff);

		Staff both = new Staff();
		both.setUsername("both@1.com");
		both.setPassword(bCryptPasswordEncoder.encode("123"));
		both.getRoleList().addAll(Arrays.asList(admin, lib));

		this.staffRepository.save(both);
	}
}
