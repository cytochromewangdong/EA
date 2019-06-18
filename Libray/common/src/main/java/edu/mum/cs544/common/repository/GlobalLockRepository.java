package edu.mum.cs544.common.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.mum.cs544.common.domain.GlobalLock;

public interface GlobalLockRepository extends JpaRepository<GlobalLock, String> {

}
