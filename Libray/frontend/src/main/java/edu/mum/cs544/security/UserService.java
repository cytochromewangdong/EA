package edu.mum.cs544.security;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import edu.mum.cs544.common.domain.LoginUser;
import edu.mum.cs544.common.domain.Role;
import edu.mum.cs544.common.dto.OpenId;
import edu.mum.cs544.common.dto.UserNamePassword;
import edu.mum.cs544.common.service.base.BaseService;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

@Service
public class UserService extends BaseService {

	@Transactional
	public LoginUser findByUsername(String username) {
		LoginUser user = loginUserRepository.findByUsernameIgnoreCase(username).orElse(null);
		return user;
	}

	@Transactional
	public OpenId authenticateUser(UserNamePassword userNamePassword) {
		LoginUser user = loginUserRepository.findByUsernameIgnoreCase(userNamePassword.getUsername()).orElse(null);
		if (user != null) {
			if (bCryptPasswordEncoder.matches(userNamePassword.getPassword(), user.getPassword())) {
				byte[] signingKey = SecurityConstants.JWT_SECRET.getBytes();

				List<String> roles = user.getRoleList().stream().map(Role::getRole).collect(Collectors.toList());
				// { username: user.email, roles: user.roles, id: user._id }
				String token = Jwts.builder().signWith(Keys.hmacShaKeyFor(signingKey), SignatureAlgorithm.HS512)
						.setHeaderParam("typ", SecurityConstants.TOKEN_TYPE).setIssuer(SecurityConstants.TOKEN_ISSUER)
						.setAudience(SecurityConstants.TOKEN_AUDIENCE).setSubject(user.getUsername())
						.setExpiration(new Date(System.currentTimeMillis() + SecurityConstants.EXPIRE_TIME))
						.claim(SecurityConstants.JWT_ROLES, roles).claim("username", user.getUsername())
						.claim("id", user.getId()).compact();

				return new OpenId(true, "Authentication successful!", token);
			}
		}
		return new OpenId(false, "Failed to Authentication", null);
	}
}
