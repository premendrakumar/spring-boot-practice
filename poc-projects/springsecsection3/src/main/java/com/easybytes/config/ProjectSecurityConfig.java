package com.easybytes.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.password.CompromisedPasswordChecker;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.password.HaveIBeenPwnedRestApiPasswordChecker;

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

        http.formLogin(withDefaults());
        http.httpBasic(withDefaults());
//        http.formLogin(flc -> flc.disable());
//        http.httpBasic(withDefaults());
        return http.build();
    }

    @Bean
    public UserDetailsService userDetailsService(){
        UserDetails user= User.withUsername("user").password("{noop}user").authorities("read").build();
        UserDetails admin= User.withUsername("admin").password("{noop}admin").authorities("admin").build();
//        UserDetails user= User.withUsername("user").password("{bcrypt}$2a$12$Q2UwLhv1oy3aihU6EKP0y.kejFrLEuto99tn0MEE9zD2VXt0b9ovG").authorities("read").build();
//        UserDetails admin= User.withUsername("admin").password("{bcrypt}$2a$12$1H4dQ9lZkui.A.G3dHoBXOLu.p3nuy6APD5/sJDrXfNP5cY7ZqfLK").authorities("admin").build();
        return new InMemoryUserDetailsManager(user,admin);
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }

//    @Bean
//    public CompromisedPasswordChecker compromisedPasswordChecker(){
//        return new HaveIBeenPwnedRestApiPasswordChecker();
//    }
}
