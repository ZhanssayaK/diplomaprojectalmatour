package com.example.diploma.project.almatour.config;

import com.example.diploma.project.almatour.service.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
@RequiredArgsConstructor
public class SecurityConfig {

    private final AuthenticationService userService;

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        AuthenticationManagerBuilder builder =
                http.getSharedObject(AuthenticationManagerBuilder.class);

        builder.userDetailsService(userService).passwordEncoder(passwordEncoder());

        http.authorizeHttpRequests(
                authorize -> authorize
                        .requestMatchers("/").permitAll()
                        .requestMatchers("/sign-in").permitAll()
                        .requestMatchers("/sign-out").permitAll()
                        .requestMatchers("/sign-up").permitAll()
                        .requestMatchers("/to-sign-up").permitAll()
                        .requestMatchers("/accomodations").permitAll()
                        .anyRequest().permitAll()
        ).formLogin(
                formLogin -> formLogin
                        .loginPage("/sign-in")
                        .loginProcessingUrl("/to-sign-in")
                        .usernameParameter("user_email")
                        .passwordParameter("user_password")
                        .defaultSuccessUrl("/profile")
                        .failureUrl("/sign-in?error")
                        .permitAll()
        ).logout(
                logout -> logout
                        .logoutUrl("/exit")
                        .logoutSuccessUrl("/sign-in")
                        .permitAll()
        ).csrf(AbstractHttpConfigurer::disable);

        return http.build();
    }
}
