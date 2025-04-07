package netology.ru.JPA_wh_1.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity(securedEnabled = true)
public class WebSecurityConfiguration {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests(authorizeHttpRequests -> authorizeHttpRequests
                .anyRequest().authenticated());
        http.headers(Customizer.withDefaults());
        http.sessionManagement(Customizer.withDefaults());
        http.formLogin(Customizer.withDefaults());
        http.anonymous(Customizer.withDefaults());
        http.csrf(Customizer.withDefaults());
        http.userDetailsService(inMemoryUserDetailsService());
        return http.build();
    }

    public PasswordEncoder encoder() {
        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }

    public UserDetailsService inMemoryUserDetailsService() {
        User.UserBuilder users = User.builder();
        InMemoryUserDetailsManager userDetailsManager = new InMemoryUserDetailsManager();
        userDetailsManager.createUser(users.username("DELETE")
                .password(encoder().encode("qwerty"))
                .roles("ADMIN")
                .build());
        userDetailsManager.createUser(users.username("READ")
                .password(encoder().encode("user"))
                .roles("USER")
                .build());
        userDetailsManager.createUser(users.username("WRITE")
                .password(encoder().encode("qwerty"))
                .build());
        return userDetailsManager;
    }
}