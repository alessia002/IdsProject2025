package it.unicam.cs.platform;

import it.unicam.cs.model.Curator;
import it.unicam.cs.enums.Permission;
import it.unicam.cs.model.User;
import org.springframework.stereotype.Component;
import java.util.List;

@Component
public class CuratorFactory extends UserFactory {
    @Override
    public User createUser(String name) {
        Curator curator = new Curator();
        curator.setUsername(name);
        curator.setPermissions(List.of(
                Permission.CREATE_PRODUCT_PACKAGE,
                Permission.DELETE_PRODUCT_PACKAGE));
        return curator;
    }
}
