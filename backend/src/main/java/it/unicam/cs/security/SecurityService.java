package it.unicam.cs.security;

import it.unicam.cs.enums.Permission;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.Collection;


@Service("SecurityService")
public class SecurityService {

    public boolean hasPermission(Permission... permissions) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();

        for (Permission p : permissions) {
            if (authorities.stream().anyMatch(a -> a.getAuthority().equals(p.name()))) {
                return true;
            }
        }
        return false;
    }
}
