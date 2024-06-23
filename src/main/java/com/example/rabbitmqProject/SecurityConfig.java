package com.example.rabbitmqProject;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

//    //Custom "UserDetailsService"
//    @Bean
//    UserDetailsService userDetailsService() {
//        InMemoryUserDetailsManager userDetailsManager = new InMemoryUserDetailsManager();
//        UserDetails user = User.withUsername("azhar").password(passwordEncoder().encode("password")).authorities("read").build();
//        userDetailsManager.createUser(user);
//        return userDetailsManager;
//    }
//    @Bean
//    BCryptPasswordEncoder passwordEncoder() {
//        return new BCryptPasswordEncoder();
//    }
    @Bean
    SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.httpBasic(Customizer.withDefaults());
        http.authorizeHttpRequests(authorize ->
                authorize.requestMatchers("/healthCheck", "/sendMessage").permitAll()
                .anyRequest().authenticated())
                .csrf(csrf -> csrf.disable());
//        http.csrf(csrf -> csrf.disable());
        return http.build();
    }
}
