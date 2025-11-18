package it.unicam.cs.security;

import it.unicam.cs.enums.Permission;
import it.unicam.cs.model.Distributor;
import it.unicam.cs.model.Producer;
import it.unicam.cs.model.Transformer;
import it.unicam.cs.model.User;
import it.unicam.cs.repository.UserRepository;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.*;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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

        String role;
        if (user instanceof Distributor) {
            role = "ROLE_DISTRIBUTOR";
        } else if (user instanceof Producer) {
            role = "ROLE_PRODUCER";
        } else if (user instanceof Transformer) {
            role = "ROLE_TRANSFORMER";
        } else {
            role = "ROLE_USER"; // default
        }

        List<SimpleGrantedAuthority> authorities = List.of(new SimpleGrantedAuthority(role));
//        authorities.addAll(
//                user.getPermissions().stream()
//                        .map(Permission::name)
//                        .map(SimpleGrantedAuthority::new)
//                        .toList()
//        );

        return new org.springframework.security.core.userdetails.User(
                user.getUsername(),
                user.getPassword(),
                authorities
        );

    }
}

