package com.example.ESEG.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
@EnableWebSecurity
public class BasicAuthenticationConfig {

    @Bean
    PasswordEncoder getPasswordEncoder() {
        return NoOpPasswordEncoder.getInstance();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.authorizeRequests()
                .antMatchers("/h2-console/**")
                .permitAll()
                .antMatchers("/api/**")
                .permitAll()
                .antMatchers("/private/**")
                .hasAnyRole("USER", "ADMIN")
                .and()
                .httpBasic(withDefaults());

        httpSecurity.csrf()
                .disable();
        httpSecurity.headers()
                .frameOptions()
                .sameOrigin();
        httpSecurity.cors();
        return httpSecurity.build();
    }

}
