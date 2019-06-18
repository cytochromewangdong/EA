package edu.mum.cs544.common.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import edu.mum.cs544.common.domain.Member;
import edu.mum.cs544.common.repository.Base.LongPrimaryKeyRepository;

@Repository
public interface MemberRepository extends LongPrimaryKeyRepository<Member> {
	Page<Member> findByRemovalFlagOrderByModifyDate(Integer flag, Pageable pageable);

}
