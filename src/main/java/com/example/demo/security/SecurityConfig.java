package com.example.demo.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	 @Override
	    protected void configure(HttpSecurity http) throws Exception {
	        http.csrf().disable();
	        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
	        http.authorizeRequests().antMatchers(HttpMethod.PUT, "/fournissur/**").permitAll();
	        http.authorizeRequests().antMatchers(HttpMethod.GET, "/fournissur/**").permitAll();
	        http.authorizeRequests().antMatchers("/article/**").permitAll();
	        http.authorizeRequests().antMatchers("/addarticle/**").permitAll();
	        http.authorizeRequests().antMatchers("/modifyarticle/**").permitAll();
	        http.authorizeRequests().antMatchers("/getallarticle/**").permitAll();
	        http.authorizeRequests().antMatchers("/deletearticle/**").permitAll();
	        http.authorizeRequests().antMatchers("/getproduct/**").permitAll();
	        
	        
	        http.authorizeRequests().anyRequest().authenticated();
	       http.addFilterBefore(new JWTAuthorizationFilter(), UsernamePasswordAuthenticationFilter.class);
	    }
}
