/**
 * 
 */
package com.thetavern.app.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * @author Fernando Nathanael
 *
 */
@SuppressWarnings("deprecation")
@Configuration
@EnableWebSecurity
public class TheTavernSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private DataSource securityDataSource;
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.jdbcAuthentication().dataSource(securityDataSource);
	}
		
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
		.antMatchers("/assets/**").permitAll()
		.antMatchers("/admin/**").hasRole("ADMIN")
		.antMatchers("/employee/**").hasAnyRole("ADMIN", "EMPLOYEE")
		.and()
		.formLogin()
			.loginPage("/login")
			.loginProcessingUrl("/authenticateTheUser")
			.permitAll()
		.and()
			.logout().permitAll()
			.logoutSuccessUrl("/login")
		.and()
			.exceptionHandling().accessDeniedPage("/access-denied");	
	}

}
