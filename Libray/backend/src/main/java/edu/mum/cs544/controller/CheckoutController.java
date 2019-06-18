package edu.mum.cs544.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.mum.cs544.common.dto.CheckoutDto;
import edu.mum.cs544.common.dto.ResultDto;
import edu.mum.cs544.service.CheckoutService;

@RestController
@RequestMapping("/api/")
@PreAuthorize("hasAuthority('system')")
public class CheckoutController {
	@Autowired
	private CheckoutService checkoutService;
	@PostMapping("/checkout/{readerId}/{bookId}")
	public CheckoutDto checkout(@PathVariable("readerId") String readerId, @PathVariable("bookId")String bookId)
	{
		return checkoutService.checkoutBook(readerId, bookId);
	}

	@PostMapping("/checkin/{bookId}")
	public ResultDto checkin(@PathVariable("bookId")String bookId)
	{
		return checkoutService.checkinBook(bookId);
	}
}
