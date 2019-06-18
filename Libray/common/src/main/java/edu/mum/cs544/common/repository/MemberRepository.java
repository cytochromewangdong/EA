package edu.mum.cs544.common.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import edu.mum.cs544.common.domain.Member;
import edu.mum.cs544.common.repository.Base.LongPrimaryKeyRepository;

@Repository
public interface MemberRepository extends LongPrimaryKeyRepository<Member> {
	Page<Member> findByRemovalFlagOrderByModifyDate(Integer flag, Pageable pageable);

	@Query("select m from Member m where removalFlag = 0 and memberId=:readerId")
	Member findbyMemberId(@Param("readerId") String readerId);
}
