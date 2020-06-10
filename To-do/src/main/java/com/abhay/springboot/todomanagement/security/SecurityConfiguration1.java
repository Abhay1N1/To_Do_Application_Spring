package com.abhay.springboot.todomanagement.security;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;

@SuppressWarnings("deprecation")
@Configuration
public class SecurityConfiguration1 extends WebSecurityConfigurerAdapter{
	@Autowired
    public void configureGlobalSecurity(AuthenticationManagerBuilder auth)
            throws Exception {
        auth.inMemoryAuthentication()
            .passwordEncoder(NoOpPasswordEncoder.getInstance())
        		.withUser("abhay").password("15179598")
                .roles("USER", "ADMIN");
        auth.inMemoryAuthentication()
        .passwordEncoder(NoOpPasswordEncoder.getInstance())
    		.withUser("java").password("ilovejava")
            .roles("USER", "USER");
        auth.inMemoryAuthentication()
        .passwordEncoder(NoOpPasswordEncoder.getInstance())
    		.withUser("ibm").password("ibm")
            .roles("USER", "USER");
    }
	
	@Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests().antMatchers("/login", "/h2-console/**").permitAll()
                .antMatchers("/", "/*todo*/**").access("hasRole('USER')").and()
                .formLogin();
        
        http.csrf().disable();
        http.headers().frameOptions().disable();
    }
}
