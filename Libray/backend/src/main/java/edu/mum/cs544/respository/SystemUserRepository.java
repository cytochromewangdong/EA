package edu.mum.cs544.respository;

import java.util.Optional;

import org.springframework.stereotype.Repository;

import edu.mum.cs544.common.repository.Base.LongPrimaryKeyRepository;
import edu.mum.cs544.domain.SystemUser;

@Repository
public interface SystemUserRepository extends LongPrimaryKeyRepository<SystemUser> {
	Optional<SystemUser> findByUsernameIgnoreCase(String username);
}
