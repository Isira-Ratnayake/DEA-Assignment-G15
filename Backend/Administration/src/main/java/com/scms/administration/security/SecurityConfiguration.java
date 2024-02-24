package com.scms.administration.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;

import java.util.List;

@Configuration
public class SecurityConfiguration {
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
//        http.cors(cors -> {
//            CorsConfigurationSource source = request -> {
//                CorsConfiguration config = new CorsConfiguration();
//                config.setAllowedOrigins(
//                        List.of(origin));
//                config.setAllowedHeaders(
//                        List.of("Authorization"));
//                config.setAllowedMethods(
//                        List.of("GET", "POST"));
//                return config;
//            };
//            cors.configurationSource(source);
//        });
        http.csrf(AbstractHttpConfigurer::disable);
        http.sessionManagement((session) -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS));
//        http.addFilterAt(new EntryLocationFilter(entryLocationAuthenticationProvider), BasicAuthenticationFilter.class)
//                .addFilterAfter(new EntryUserFilter(entryUserAuthenticationProvider), BasicAuthenticationFilter.class)
//                .addFilterAfter(new JwtAuthenticationFilter(entryUserDetailsService), BasicAuthenticationFilter.class);
        http.authorizeHttpRequests((auth) -> auth.anyRequest().permitAll());
        return http.build();
    }
}
