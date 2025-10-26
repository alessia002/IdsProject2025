package it.unicam.cs.platform;

import it.unicam.cs.enums.Permission;
import it.unicam.cs.model.Producer;
import it.unicam.cs.model.User;
import org.springframework.stereotype.Component;
import java.util.List;

@Component
public class ProducerFactory extends UserFactory {
    @Override
    public User createUser(String name) {
        Producer producer = new Producer();
        producer.setName(name);
        producer.setPermissions(List.of(
                Permission.UPLOAD_PRODUCT,
                Permission.REMOVE_PRODUCT,
                Permission.PUBLISH_PRODUCT));
        return producer;
    }
}
