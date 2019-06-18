package edu.mum.cs544.common.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.mum.cs544.common.domain.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, String> {

}
