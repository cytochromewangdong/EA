package edu.mum.cs544.respository;

import org.springframework.stereotype.Repository;

import edu.mum.cs544.common.domain.BookCopy;
import edu.mum.cs544.common.repository.Base.LongPrimaryKeyRepository;

@Repository
public interface BookCopyRepository extends LongPrimaryKeyRepository<BookCopy> {
	BookCopy findByGuid(String bookId);
}
