package it.unicam.cs.platform;

import it.unicam.cs.enums.Role;
import it.unicam.cs.model.RegistrationRequest;
import it.unicam.cs.model.User;


public class UserFactory {
    public User createUser(RegistrationRequest request){
        User user = new User();
        user.setUsername(request.getUsername());
        user.setPassword(request.getPassword());
        user.setLocation(request.getLocation());
        user.setSupplyChain(request.getSupplyChain());
        authorizeUser(user);
        return user;
    }

    public User authorizeUser(User user) {
        user.addRole(Role.ROLE_USER);
        return user;
    }
}
