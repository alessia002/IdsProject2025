package it.unicam.cs.security;

import it.unicam.cs.enums.Role;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.Collection;


@Service("SecurityService")
public class SecurityService {

    public boolean hasRoles(Role... roles) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();

        for (Role r : roles) {
            if (authorities.stream().anyMatch(a -> a.getAuthority().equals(r.name()))) {
                return true;
            }
        }
        return false;
    }
}
