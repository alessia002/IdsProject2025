package it.unicam.cs.platform;

import it.unicam.cs.enums.Role;

public class UserFactorySelector {
    public static UserFactory getFactory(Role role){
            return switch (role) {
                case ROLE_USER -> new UserFactory();
                case ROLE_PRODUCER -> new ProducerFactory();
                case ROLE_TRANSFORMER -> new TransformerFactory();
                case ROLE_DISTRIBUTOR -> new DistributorFactory();
                case ROLE_CURATOR -> new CuratorFactory();
                default -> throw new IllegalArgumentException("Invalid role");
            };
    }
}
