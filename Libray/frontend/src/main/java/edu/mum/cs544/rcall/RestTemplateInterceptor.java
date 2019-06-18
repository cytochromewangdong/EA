package edu.mum.cs544.rcall;

import java.io.IOException;

import org.springframework.http.HttpRequest;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;

import edu.mum.cs544.security.SecurityConstants;

public class RestTemplateInterceptor implements ClientHttpRequestInterceptor {

	private final AuthService authService;

	public RestTemplateInterceptor(AuthService authService) {

		this.authService = authService;
	}

	@Override
	public ClientHttpResponse intercept(HttpRequest request, byte[] body, ClientHttpRequestExecution execution)
			throws IOException {

		// String token = RequestContext.getContext().getToken();
		//
		request.getHeaders().add(SecurityConstants.TOKEN_HEADER,
				SecurityConstants.TOKEN_PREFIX + authService.getToken());

		return execution.execute(request, body);

	}

}