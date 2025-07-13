package com.easybytes.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
public class ProjectSecurityConfig {
    @Bean
    SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {
//        http.authorizeHttpRequests((requests) -> requests
//                .anyRequest().authenticated());
        http.authorizeHttpRequests((requests) -> requests
                .requestMatchers("/", "/myAccounts").authenticated()
                .requestMatchers("/notices","/error").permitAll());

//        http.formLogin(withDefaults());
//        http.httpBasic(withDefaults());
        http.formLogin(flc -> flc.disable());
        http.httpBasic(withDefaults());
        return http.build();
    }
}
