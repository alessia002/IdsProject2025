package it.unicam.cs.platform;

import it.unicam.cs.enums.Role;
import it.unicam.cs.model.User;
import org.springframework.stereotype.Component;

@Component
public class DistributorFactory extends UserFactory {
    @Override
    public User authorizeUser(User user) {
        user.addRole(Role.ROLE_DISTRIBUTOR);
        return user;
    }
    @Override
    public void unauthorizeUser(User user) {
        user.removeRole(Role.ROLE_DISTRIBUTOR);
    }
}
