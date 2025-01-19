/*
package com.ingJorgePertuz.foroHubAlura.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.HttpBasicConfigurer;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        HttpBasicConfigurer<HttpSecurity> httpSecurityHttpBasicConfigurer = http
                .csrf().disable() // Deshabilita la protección CSRF
                .authorizeHttpRequests((authz) -> authz
                        .anyRequest().permitAll() // Permite todas las solicitudes
                )
                .httpBasic();// Añadir autenticación básica
        return http.build();
    }
}



*/
package com.ingJorgePertuz.foroHubAlura.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf().disable() // Deshabilita la protección CSRF
                .authorizeHttpRequests(authorizeRequests ->
                        authorizeRequests
                                .requestMatchers("/users/**").authenticated() // Requiere autenticación para /users/*
                                .anyRequest().authenticated() // Requiere autenticación para cualquier otra solicitud
                )
                .httpBasic(); // Añade autenticación básica

        return http.build();
    }

    @Bean
    public UserDetailsService userDetailsService() {
        var userDetailsManager = new InMemoryUserDetailsManager();
        userDetailsManager.createUser(User.withUsername("admin")
                .password("{noop}admin123") // {noop} se utiliza para indicar que no se debe aplicar ningún algoritmo de cifrado
                .roles("ADMIN")
                .build());
        return userDetailsManager;
    }
}