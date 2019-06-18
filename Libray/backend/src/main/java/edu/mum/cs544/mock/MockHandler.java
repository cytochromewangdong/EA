package edu.mum.cs544.mock;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.mum.cs544.common.service.base.BaseService;
import edu.mum.cs544.domain.SystemUser;
import edu.mum.cs544.respository.SystemUserRepository;

@Service
@Transactional
public class MockHandler extends BaseService {

	@Autowired
	private SystemUserRepository systemUserRepository;
	public void createMockData() {
		// admin
		// lib
		// norm

		// staffRepository.deleteAll();
		// this.roleRepository.deleteAll();
		createStaffAndRole();
	}


	private void createStaffAndRole() {
		systemUserRepository.deleteAll(systemUserRepository.findAll());
		SystemUser lb = new SystemUser();
		lb.setUsername("2");
		lb.setPassword(bCryptPasswordEncoder.encode("2"));

		systemUserRepository.save(lb);
		
	}
}
