package edu.mum.cs544.common.repository.Base;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface LongPrimaryKeyRepository<T> extends JpaRepository<T, Long> {
	Page<T> findByRemovalFlagOrderByModifyDate(Integer flag, Pageable pageable);
	List<T> findByRemovalFlag(Integer flag);
}
