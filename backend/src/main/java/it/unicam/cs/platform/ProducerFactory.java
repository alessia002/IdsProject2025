package it.unicam.cs.platform;

import it.unicam.cs.enums.Role;
import it.unicam.cs.model.User;
import org.springframework.stereotype.Component;

@Component
public class ProducerFactory extends UserFactory {
    @Override
    public User authorizeUser(User user) {
        user.addRole(Role.ROLE_PRODUCER);
        return user;
    }
}
