package com.devEmersonc.gestion_de_inventarios.config;

import com.devEmersonc.gestion_de_inventarios.security.JwtAuthenticationEntryPoint;
import com.devEmersonc.gestion_de_inventarios.security.JwtFIlter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.access.AccessDeniedHandlerImpl;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity(securedEnabled = true, prePostEnabled = true)
public class SecurityConfig {
    private final JwtAuthenticationEntryPoint jwtAuthenticationEntryPoint;
    private final JwtFIlter jwtFIlter;

    public SecurityConfig(JwtAuthenticationEntryPoint jwtAuthenticationEntryPoint, JwtFIlter jwtFIlter) {
        this.jwtAuthenticationEntryPoint = jwtAuthenticationEntryPoint;
        this.jwtFIlter = jwtFIlter;
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.csrf(csrf -> csrf.disable())
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers(HttpMethod.POST, "/api/auth/login").permitAll()
                        .requestMatchers(HttpMethod.GET, "/api/users").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.GET, "/api/users/{id}").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.POST, "/api/users/save-normal-user").permitAll()
                        .requestMatchers(HttpMethod.POST, "/api/users/save-admin-user").permitAll()
                        .requestMatchers(HttpMethod.PUT, "/api/users/{id}").authenticated()
                        .requestMatchers(HttpMethod.DELETE, "/api/users/{id}").authenticated()
                        .requestMatchers(HttpMethod.GET, "/api/products").hasAnyRole("ADMIN", "USER")
                        .requestMatchers(HttpMethod.GET, "/api/products/{id}").hasAnyRole("ADMIN", "USER")
                        .requestMatchers(HttpMethod.POST, "/api/products").authenticated()
                        .requestMatchers(HttpMethod.PUT, "/api/products/{id}").authenticated()
                        .requestMatchers(HttpMethod.DELETE, "/api/products/{id}").authenticated()
                        .requestMatchers(HttpMethod.GET, "/api/categories").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.GET, "/api/categories/{id}").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.POST, "/api/categories").authenticated()
                        .requestMatchers(HttpMethod.PUT, "/api/categories/{id}").authenticated()
                        .requestMatchers(HttpMethod.DELETE, "/api/categories/{id}").authenticated()
                        .requestMatchers(HttpMethod.GET, "/api/suppliers").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.GET, "/api/suppliers/{id}").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.POST, "/api/supppliers").authenticated()
                        .requestMatchers(HttpMethod.PUT, "/api/suppliers/{id}").authenticated()
                        .requestMatchers(HttpMethod.DELETE, "/api/suppliers/{id}").authenticated()
                        .anyRequest().authenticated())
                .exceptionHandling(exceptionHandling -> exceptionHandling.authenticationEntryPoint(jwtAuthenticationEntryPoint))
                .sessionManagement(sess -> sess.sessionCreationPolicy(SessionCreationPolicy.STATELESS));
        httpSecurity.addFilterBefore(jwtFIlter, UsernamePasswordAuthenticationFilter.class);
        return httpSecurity.build();
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception{
        return config.getAuthenticationManager();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
