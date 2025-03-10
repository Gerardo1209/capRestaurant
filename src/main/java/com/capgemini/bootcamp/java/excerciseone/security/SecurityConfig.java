package com.capgemini.bootcamp.java.excerciseone.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import javax.sql.DataSource;

@Configuration
public class SecurityConfig {

    @Bean
    public JdbcUserDetailsManager userDetailsManager(DataSource dataSource){
        var judm = new JdbcUserDetailsManager(dataSource);
        judm.setUsersByUsernameQuery("SELECT name, password, active FROM employee WHERE name=?");
        judm.setAuthoritiesByUsernameQuery("SELECT E.name, R.name FROM employee E, role R WHERE E.name=? and E.idRole=R.id");
        return judm;
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.authorizeHttpRequests(
                configure -> {
                    configure
                            .requestMatchers(HttpMethod.GET, "/").permitAll()
                            .requestMatchers(HttpMethod.POST, "/").permitAll()
                            .requestMatchers(HttpMethod.GET, "/api/product").permitAll()
                            .requestMatchers(HttpMethod.GET, "/api/product/**").permitAll()
                            .requestMatchers(HttpMethod.POST, "/api/product").permitAll()
                            .requestMatchers(HttpMethod.GET, "/swagger-ui/**").permitAll()
                            .requestMatchers(HttpMethod.GET, "/v3/api-docs*/**").permitAll();
                }
        );

        httpSecurity.httpBasic(Customizer.withDefaults());
        httpSecurity.csrf(AbstractHttpConfigurer::disable);

        return httpSecurity.build();
    }

}
