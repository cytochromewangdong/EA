package edu.mum.cs544.rcall;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.web.client.RestTemplate;

@Configuration
public class RemoteCallConfigure {

	@Autowired
	private AuthService authService;

	@Bean
	public RestTemplate restTemplate() {
		RestTemplate restTemplate = new RestTemplate();

		List<ClientHttpRequestInterceptor> interceptors = restTemplate.getInterceptors();
		if (interceptors == null) {
			interceptors = new ArrayList<>();
		}
		interceptors.add(new RestTemplateInterceptor(authService));
		restTemplate.setInterceptors(interceptors);
		return restTemplate;
	}
}
