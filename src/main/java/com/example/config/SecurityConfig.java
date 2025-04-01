package com.example.productos.config; 
import org.springframework.http.HttpMethod;

import org.springframework.context.annotation.Bean; 
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.security.config.Customizer; 
import org.springframework.security.config.web.server.ServerHttpSecurity; 
import org.springframework.security.core.userdetails.MapReactiveUserDetailsService; 
import org.springframework.security.core.userdetails.User; 
import org.springframework.security.core.userdetails.UserDetails; 
import org.springframework.security.web.server.SecurityWebFilterChain; 
 
@Configuration 
public class SecurityConfig { 
 
    @Bean
    public SecurityWebFilterChain springSecurityFilterChain(ServerHttpSecurity http) {
        http
            .csrf(ServerHttpSecurity.CsrfSpec::disable)  // Deshabilita CSRF si no usas tokens
            .authorizeExchange(exchanges -> exchanges
                .pathMatchers(HttpMethod.GET, "/api/**").permitAll()  // GET sin autenticación
                .pathMatchers(HttpMethod.POST, "/api/**").authenticated() // POST requiere login
                .anyExchange().permitAll()
            )
            .httpBasic(Customizer.withDefaults())  
            .formLogin(Customizer.withDefaults());     
        return http.build();
    }
 
    @Bean 
    public MapReactiveUserDetailsService userDetailsService() { 
        UserDetails user = User.withDefaultPasswordEncoder() 
            .username("usuario") 
            .password("clave123") 
            .roles("USER") 
            .build(); 
 
        return new MapReactiveUserDetailsService(user); 
    } 


}