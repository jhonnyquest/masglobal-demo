/******************************************************************
 *
 * MAS Global - Hiring process application test.
 *
 *
 * © 2019, Jhonny Munoz All rights reserved.
 *
 ******************************************************************/

package com.masglobal.demo.security;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.HttpStatusEntryPoint;

/***
 * Main security configuration files where resides the authorization rules and
 * general configuration features
 * 
 * @author jmunoz
 * @since 09/03/2019
 * @version 1.0.0
 *
 */
@EnableWebSecurity
@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	private static final Logger LOGGER = LogManager.getLogger(SecurityConfig.class);

	/**
	 * <b>configure</b>: Configuration setup to disable CSRF verification, basic security and allow all
	 * 			calls to endpoints under v1 path
	 *
	 * @since 09/03/2019
	 * @author jmunoz
	 * @param http http security bean
	 * @throws Exception general exception
	 */
	@Override
	protected void configure(HttpSecurity http) throws Exception {

		http.headers().defaultsDisabled().cacheControl().and().httpStrictTransportSecurity()
				.and().contentTypeOptions().and().xssProtection().and().frameOptions();

		http.csrf().disable();
		
		http.authorizeRequests().mvcMatchers("/v1").permitAll().and().csrf().disable();
		http.exceptionHandling().authenticationEntryPoint(
				new HttpStatusEntryPoint(HttpStatus.UNAUTHORIZED)).and().sessionManagement();
	}


	/**
	 * <b>configure</b>: Method used to activate debug security trace based on logger level
	 *
	 * @since 09/03/2019
	 * @author jmunoz
	 * @param web WebSecurity context
	 * @throws Exception general exception
	 */
	@Override
	public void configure(WebSecurity web) throws Exception {
		if (LOGGER.isDebugEnabled()) {
			web.debug(true);
		}
	}

}
