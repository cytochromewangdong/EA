package edu.mum.cs544.security;

import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import edu.mum.cs544.common.domain.LoginUser;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private UserService userService;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		LoginUser loginUser = userService.findByUsername(username);
		if (loginUser == null) {
			throw new UsernameNotFoundException(username);
		}
		return new User(loginUser.getUsername(), loginUser.getPassword(), loginUser.getRoleList().stream()
				.map(r -> new SimpleGrantedAuthority(r.getRole())).collect(Collectors.toList()));
	}
}
