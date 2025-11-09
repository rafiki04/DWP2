/*package com.product.config.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
public class UserConfig {

    @Bean
    public InMemoryUserDetailsManager users() {
        @SuppressWarnings("deprecation")
		UserDetails user = User.withDefaultPasswordEncoder()
            .username("user")
            .password("aeab61dd-15e3-414b-9308-345ca7c5ee02")
            .authorities("CUSTOMER","ADMIN") // roles necesarios
            .build();
        return new InMemoryUserDetailsManager(user);
    }
}
*/