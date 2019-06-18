package edu.mum.cs544.service;

import java.time.LocalDateTime;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.mum.cs544.common.domain.BookCopy;
import edu.mum.cs544.common.domain.CheckoutEntry;
import edu.mum.cs544.common.domain.CheckoutEntryHistory;
import edu.mum.cs544.common.domain.Member;
import edu.mum.cs544.common.dto.CheckoutDto;
import edu.mum.cs544.common.dto.ResultDto;
import edu.mum.cs544.common.service.base.BaseService;
import edu.mum.cs544.respository.BookCopyRepository;

@Service
@Transactional
public class CheckoutService extends BaseService {

	@Autowired
	private BookCopyRepository bookCopyRepository;

	public CheckoutDto checkoutBook(String readerId, String bookId) {
		CheckoutDto result = new CheckoutDto();
		BookCopy bc = bookCopyRepository.findByGuid(bookId);
		if (bc == null) {
			result.setMessage("The book does not exist!");
			result.setResult(false);
			return result;
		}
		if (bc.getCheckoutEntry() != null) {
			result.setMessage("The book has been borrowed!");
			result.setResult(false);
			return result;
		}
		Member member = this.memberRepository.findbyMemberId(readerId);
		if (member == null) {
			result.setMessage("The reader does not exist!");
			result.setResult(false);
			return result;
		}

		LocalDateTime dueDate = LocalDateTime.now().plusDays(bc.getBook().getLoanDuration());
		CheckoutEntry checkout = new CheckoutEntry();
		checkout.setMember(member);
		checkout.setDueDate(dueDate);
		checkout.setCheckoutDate(LocalDateTime.now());
		checkout.setBookCopy(bc);
		member.getCheckoutEntryList().add(checkout);
		bc.setCheckoutEntry(checkout);
		result.setDueDate(dueDate);
		return result;
	}

	public ResultDto checkinBook(String bookId) {
		ResultDto result = new ResultDto();
		BookCopy bc = bookCopyRepository.findByGuid(bookId);
		if (bc == null) {
			result.setMessage("The book does not exist!");
			result.setResult(false);
			return result;
		}
		if (bc.getCheckoutEntry() == null) {
			result.setMessage("It is a mistake? The book has not been borrowed!");
			result.setResult(false);
			return result;
		}
		CheckoutEntry ce = bc.getCheckoutEntry();
		ce.setBookCopy(null);
		ce.getMember().getCheckoutEntryList().remove(ce);
		CheckoutEntryHistory ceHistory = new CheckoutEntryHistory();
		ceHistory.setBookCopy(bc);
		ceHistory.setCheckoutDate(ce.getCheckoutDate());
		ceHistory.setMember(ce.getMember());
		ceHistory.setDueDate(ce.getDueDate());
		ce.getMember().getCheckoutEntryHistoryList().add(ceHistory);
		bc.getCheckoutEntryHistoryList().add(ceHistory);
		bc.setCheckoutEntry(null);
		return result;
	}
}
