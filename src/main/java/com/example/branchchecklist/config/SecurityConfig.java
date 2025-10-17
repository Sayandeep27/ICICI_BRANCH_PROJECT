package com.example.branchchecklist.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class SecurityConfig {

    private final JwtAuthFilter jwtAuthFilter;

    public SecurityConfig(JwtAuthFilter jwtAuthFilter) {
        this.jwtAuthFilter = jwtAuthFilter;
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .csrf(csrf -> csrf.disable())
            .authorizeHttpRequests(auth -> auth
                // ✅ Allow access to static frontend pages
                .requestMatchers(
                    "/", 
                    "/index.html",
                    "/branch.html",
                    "/checklist.html",
                    "/success.html",
                    "/style.css",
                    "/js/**",
                    "/images/**"
                ).permitAll()

                // ✅ Allow public access to authentication and mobile endpoints
                .requestMatchers("/auth/**", "/mobile", "/mobile-submit").permitAll()

                // ✅ Allow public access to checklist & branch endpoints for UI
                .requestMatchers(
                    "/api/checklist-section/**", 
                    "/api/branch/**", 
                    "/api/branches", 
                    "/branch"
                ).permitAll()

                // ✅ All other API requests need valid JWT
                .anyRequest().authenticated()
            )

            // ✅ Use stateless session management for JWT
            .sessionManagement(session -> 
                session.sessionCreationPolicy(SessionCreationPolicy.STATELESS)
            )

            // ✅ Add JWT filter before username/password authentication
            .addFilterBefore(jwtAuthFilter, UsernamePasswordAuthenticationFilter.class);

        return http.build();
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authConfig) throws Exception {
        return authConfig.getAuthenticationManager();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
