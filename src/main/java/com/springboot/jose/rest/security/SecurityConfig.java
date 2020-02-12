package com.springboot.jose.rest.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.access.AccessDeniedHandler;

import lombok.RequiredArgsConstructor;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
@RequiredArgsConstructor
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	
	private final CustomBasicAuthenticationEntryPoint customBasicAuthenticationEntryPoint;
	private final UserDetailsService userDetailsService;
	private final PasswordEncoder passwordEncoder;
	private final AccessDeniedHandler accessDeniedHandler;
	
	
	/*
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder);
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
		
			.httpBasic();
				http.csrf().disable().exceptionHandling().authenticationEntryPoint(customBasicAuthenticationEntryPoint).and()
			//.authenticationEntryPoint(customBasicAuthenticationEntryPoint)
				
			.authorizeRequests()
			.antMatchers("/producto/*").permitAll()
			.antMatchers(HttpMethod.OPTIONS, "/**").permitAll().antMatchers(HttpMethod.POST, "/login").permitAll()
				.antMatchers(HttpMethod.POST, "/producto/**", "//**").permitAll()//hasRole("ADMIN")
				.antMatchers(HttpMethod.PUT, "/producto/**").permitAll() //hasRole("ADMIN")
				.antMatchers(HttpMethod.DELETE, "/producto/**").permitAll()//.hasRole("ADMIN")
				.antMatchers(HttpMethod.POST, "/pedido/**").permitAll()//hasAnyRole("USER","ADMIN")
				//.permitAll()
				.anyRequest().authenticated();
			//.and()
			//	.csrf().disable();
		
		//http.exceptionHandling()
			//.accessDeniedHandler(accessDeniedHandler);
	
	}
	*/

	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring()
		.antMatchers("/*/**");
		
	}


	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// TODO Auto-generated method stub
		super.configure(http);
	}
	
	
	
	
}
