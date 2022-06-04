/**
 * 
 */
package com.thetavern.app.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.User.UserBuilder;

/**
 * @author Fernando Nathanael
 *
 */
@SuppressWarnings("deprecation")
@Configuration
@EnableWebSecurity
public class TheTavernSecurityConfig extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		
		// add our users for in memory authentication
		UserBuilder users = User.withDefaultPasswordEncoder();
		
		auth.inMemoryAuthentication()
			.withUser(users.username("john").password("thebesttavern").roles("EMPLOYEE"))
			.withUser(users.username("mary").password("thebesttavern").roles("MANAGER"))
			.withUser(users.username("susan").password("thebesttavern").roles("ADMIN"));
	}

}
