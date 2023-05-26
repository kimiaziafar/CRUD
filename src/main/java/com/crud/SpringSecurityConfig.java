package com.crud.secutity;


import org.springframework.context.annotation.*;
import org.springframework.security.authentication.dao.*;
import org.springframework.security.config.annotation.AbstractSecurityBuilder;
import org.springframework.security.config.annotation.authentication.builders.*;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.*;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.DefaultSecurityFilterChain;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class WebSecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity httpSecurity)
      throws Exception {
        httpSecurity.authorizeRequests()
          .requestMatchers("/h2-console/**")
          .permitAll()
          .anyRequest()
          .authenticated()
          .and()
          .formLogin();
        
        httpSecurity.csrf()
          .ignoringRequestMatchers("/h2-console/**");
        httpSecurity.headers()
          .frameOptions()
          .sameOrigin();
      AbstractSecurityBuilder<DefaultSecurityFilterChain> http = null;
	return http.build();
    }
    
    
}
