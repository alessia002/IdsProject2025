package it.unicam.cs.platform;

import it.unicam.cs.model.Distributor;
import it.unicam.cs.enums.Permission;
import it.unicam.cs.model.User;
import org.springframework.stereotype.Component;
import java.util.List;

@Component
public class DistributorFactory extends UserFactory {
    @Override
    public User createUser(String name) {
        Distributor distributor = new Distributor();
        distributor.setUsername(name);
        distributor.setPermissions(List.of(
                Permission.MARKETPLACE_EDIT));
        return distributor;
    }
}
