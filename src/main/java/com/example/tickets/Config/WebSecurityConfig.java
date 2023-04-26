package com.example.tickets.Config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.LogoutConfigurer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.access.expression.WebExpressionAuthorizationManager;


/**
 * Class required for authentication in the system
 * @author Artem Petrikov
 */
@Configuration
@EnableWebSecurity
public class WebSecurityConfig {

    @Value("${uslog}") // Login for the user
    private String uslog;

    @Value("${uspass}") // Password for the user
    private String uspass;

    @Value("${adlog}") // Login for the admin
    private String adlog;

    @Value("${adpass}")
    private String adpass; // Password for the admin

    /**
     * Security filter, allows access to certain pages by certain roles (Admin/User)
     * @param http http it is HttpSecurity. HttpSecurity is used to configure authorization rules for HTTP requests.
     * @return http.build()
     * @throws Exception if an error occurs while configuring the authorization rules.
     */
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.cors().and().csrf().disable();
        http
                .authorizeHttpRequests((requests) -> requests
                        .requestMatchers("/","/edit3/*","/save3/*","/result","/charge","/payment/*").permitAll()
                        .requestMatchers("/admin","/new2","/edit2/*").hasRole("ADMIN")
                        .requestMatchers("/user").access(new WebExpressionAuthorizationManager("hasRole('ADMIN') or hasRole('USER')"))
                        .anyRequest().authenticated()

                )
                .formLogin((form) -> form
                        .loginPage("/login")
                        .permitAll()
                )
                .logout(LogoutConfigurer::permitAll);


        return http.build();
    }

    /**
     * This method is necessary to add users to the system
     * @return InMemoryUserDetailsManager(user,user2)
     */
    @Bean
    public UserDetailsService userDetailsService() {
        UserDetails user =
                User.withDefaultPasswordEncoder()
                        .username(uslog)
                        .password(uspass)
                        .roles("USER")
                        .build();
        UserDetails user2 =
                User.withDefaultPasswordEncoder()
                        .username(adlog)
                        .password(adpass)
                        .roles("ADMIN")
                        .build();
        return new InMemoryUserDetailsManager(user,user2);
    }

}