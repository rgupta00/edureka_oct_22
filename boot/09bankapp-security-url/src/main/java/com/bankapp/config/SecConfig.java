package com.bankapp.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity//(debug = true)
						//	@Role					@Secure					@PreAuthorized vs @PostAuthorized
@EnableGlobalMethodSecurity(jsr250Enabled = true,  securedEnabled = true, prePostEnabled = true)
public class SecConfig extends WebSecurityConfigurerAdapter {

	//for authentication: 401
	
	@Autowired
	private UserDetailsService userDetailsService;
	
	//authentication : who are you?
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService);
	}
	
	
	//for timebeing i dont want to use a password encoder
	@Bean
	public PasswordEncoder getPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	
	//hey spring sec forgive static resources, css bootstrap etc
	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring().antMatchers("/h2/**");
	}
	
	//for authrization: 403
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable()
		.authorizeHttpRequests()
		.anyRequest().authenticated()
		.and()
	
		.httpBasic()	//as it is REST i dont need login page or ui
		.and()
		.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);	//must be statelesss
	}

}
/*
 * .antMatchers("/api/accounts/**").hasAnyRole("ADMIN","MGR")
		.antMatchers("/api/transaction/**").hasAnyRole("ADMIN","MGR", "CLERK")
		.antMatchers("/home/**").permitAll()
 */












