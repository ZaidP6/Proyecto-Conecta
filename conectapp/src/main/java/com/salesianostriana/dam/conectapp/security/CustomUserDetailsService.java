package com.salesianostriana.dam.conectapp.security;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // Aquí debes cargar el usuario desde tu base de datos o cualquier otra fuente de datos.
        // Ejemplo:
        if ("user".equals(username)) {
            return org.springframework.security.core.userdetails.User
                    .withUsername(username)
                    .password("{noop}1234")
                    .roles("USER")
                    .build();
        } else {
            throw new UsernameNotFoundException("User not found");
        }
    }
}