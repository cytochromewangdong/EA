package edu.mum.cs544;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication().withUser("both").password("{noop}123").roles("USER", "ADMIN").and()
				.withUser("user").password("{noop}123").roles("USER");
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().antMatchers("/books/**").hasAnyRole("ADMIN", "USER")
				.antMatchers(HttpMethod.GET, "/cars/**").hasAnyRole("ADMIN", "USER")//
				.antMatchers(HttpMethod.POST, "/cars/**").hasRole("ADMIN").and().formLogin().permitAll().and().logout()
				.and();
		// .csrf().disable();
	}

	@Override
	public void configure(WebSecurity web) throws Exception {
		web.debug(true);
	}

}
