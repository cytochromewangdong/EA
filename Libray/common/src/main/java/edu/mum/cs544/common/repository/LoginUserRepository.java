package edu.mum.cs544.common.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.stereotype.Repository;

import edu.mum.cs544.common.domain.LoginUser;
import edu.mum.cs544.common.repository.Base.LongPrimaryKeyRepository;

@Repository
public interface LoginUserRepository extends LongPrimaryKeyRepository<LoginUser> {
	@EntityGraph(attributePaths = { "roleList" })
	Optional<LoginUser> findByUsernameIgnoreCase(String username);
}
