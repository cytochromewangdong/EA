package edu.mum.cs544.common.repository;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.stereotype.Repository;

import edu.mum.cs544.common.domain.Staff;
import edu.mum.cs544.common.repository.Base.LongPrimaryKeyRepository;

@Repository
public interface StaffRepository extends LongPrimaryKeyRepository<Staff> {
	@EntityGraph(attributePaths= {"roleList"})
	Page<Staff> findByRemovalFlagOrderByModifyDate(Integer flag, Pageable pageable);
	@EntityGraph(attributePaths= {"roleList"})
	Optional<Staff> findById(Long id);
}
