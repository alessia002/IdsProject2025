package it.unicam.cs.platform;

import it.unicam.cs.enums.Permission;
import it.unicam.cs.model.Transformer;
import it.unicam.cs.model.User;
import org.springframework.stereotype.Component;
import java.util.List;

@Component
public class TransformerFactory extends UserFactory {
    @Override
    public User createUser(String name) {
        Transformer transformer = new Transformer();
        transformer.setUsername(name);
        transformer.setPermissions(List.of(
                Permission.ADD_TRANSFORMATION_INFO));
        return transformer;
    }
}
