package com.example.demoCRUD.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import javax.sql.DataSource;

@Configuration
public class DemoSecurityConfig {

    @Bean
    public UserDetailsManager userDetailsManager(DataSource dataSource){
        JdbcUserDetailsManager manager = new JdbcUserDetailsManager(dataSource);

        manager.setUsersByUsernameQuery("SELECT username, password, enabled FROM members WHERE username = ?");

        manager.setAuthoritiesByUsernameQuery("SELECT user_id, role FROM roles WHERE user_id = ?");

        return manager;
    }

    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests(customizer ->
            customizer.requestMatchers(HttpMethod.GET, "/api/users").hasRole("EMPLOYEE")
                    .requestMatchers(HttpMethod.GET, "/api/users/**").hasRole("EMPLOYEE")
                    .requestMatchers(HttpMethod.POST, "/api/users").hasRole("MANAGER")
                    .requestMatchers(HttpMethod.PUT, "/api/users").hasRole("MANAGER")
                    .requestMatchers(HttpMethod.DELETE, "/api/users/**").hasRole("ADMIN")
        );

        http.httpBasic();

        http.csrf().disable();

        return http.build();
    }
}
