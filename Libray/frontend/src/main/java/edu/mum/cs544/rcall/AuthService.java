package edu.mum.cs544.rcall;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import edu.mum.cs544.common.dto.OpenId;
import edu.mum.cs544.common.dto.UserNamePassword;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;

@Service
public class AuthService {
	private Map<String, String> tokenCache = new ConcurrentHashMap<>();

	public String getToken() {
		// String username = "2";
		// String password = "2";

		String url = BackEndConstants.BACKEND_SERVER + "login";
		String token = tokenCache.get(url);
		if (token != null) {
			try {
				int pos = token.lastIndexOf('.');
				String withoutSignature = token.substring(0, pos + 1);
				Jwts.parser().parse(withoutSignature);
				return token;
			} catch (ExpiredJwtException exception) {
				token = null;
				// If it is expired, let us get a new one.
			}
		}
		// HttpHeaders requestHeaders = new HttpHeaders();
		// requestHeaders.add("Accept", MediaType.APPLICATION_JSON_VALUE);
		// requestHeaders.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
		// MultiValueMap<String, String> body = new LinkedMultiValueMap<String,
		// String>();
		// body.add("username", "2");
		// body.add("password", "2");
		// request entity is created with request headers
		// HttpEntity<MultiValueMap<String, String>> requestEntity = new
		// HttpEntity<>(body, requestHeaders);
		RestTemplate restTemplate = new RestTemplate();
		// ResponseEntity<Void> responseEntity = restTemplate.exchange(url,
		// HttpMethod.POST, requestEntity, Void.class);
		UserNamePassword userNamePassword = new UserNamePassword();
		userNamePassword.setPassword("2");
		userNamePassword.setUsername("2");
		OpenId openId = restTemplate.postForObject(url, userNamePassword, OpenId.class);
		if (openId.isResult()) {
			token = openId.getOpenId();// responseEntity.getHeaders().getFirst("token");
			tokenCache.put(url, token);
			return token;
		}
		return null;
	}
}
