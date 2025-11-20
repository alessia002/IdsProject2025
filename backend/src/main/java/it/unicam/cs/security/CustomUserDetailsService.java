package it.unicam.cs.security;

import it.unicam.cs.enums.Role;
import it.unicam.cs.model.User;
import it.unicam.cs.repository.UserRepository;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.*;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    public CustomUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findById(username)
                .orElseThrow(() -> new UsernameNotFoundException("Utente non trovato: " + username));
        List<SimpleGrantedAuthority> authorities = new java.util.ArrayList<>(user.getRoles().stream()
                .map(Role::name)
                .map(SimpleGrantedAuthority::new)
                .toList());

        return new org.springframework.security.core.userdetails.User(
                user.getUsername(),
                user.getPassword(),
                authorities
        );

    }

}


