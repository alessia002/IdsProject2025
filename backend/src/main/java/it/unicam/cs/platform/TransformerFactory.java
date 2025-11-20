package it.unicam.cs.platform;

import it.unicam.cs.enums.Role;
import it.unicam.cs.model.RegistrationRequest;
import it.unicam.cs.model.User;
import org.springframework.stereotype.Component;
import java.util.List;

@Component
public class TransformerFactory extends UserFactory {
    @Override
    public User createUser(RegistrationRequest request) {
        return User.builder()
                .username(request.getUsername())
                .password(request.getPassword())
                .roles(List.of(Role.ROLE_TRANSFORMER))
                .build();
    }
}
