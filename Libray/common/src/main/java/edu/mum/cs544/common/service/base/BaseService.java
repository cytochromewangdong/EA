package edu.mum.cs544.common.service.base;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import edu.mum.cs544.common.repository.BookRepository;
import edu.mum.cs544.common.repository.LoginUserRepository;
import edu.mum.cs544.common.repository.MemberRepository;
import edu.mum.cs544.common.repository.RoleRepository;
import edu.mum.cs544.common.repository.StaffRepository;

public abstract class BaseService {
	@Autowired
	protected StaffRepository staffRepository;
	@Autowired
	protected MemberRepository memberRepository;
	@Autowired
	protected RoleRepository roleRepository;
	@Autowired
	protected BookRepository bookRepository;
	
	@Autowired
	protected BCryptPasswordEncoder bCryptPasswordEncoder;

	@Autowired
	protected LoginUserRepository loginUserRepository;
}
