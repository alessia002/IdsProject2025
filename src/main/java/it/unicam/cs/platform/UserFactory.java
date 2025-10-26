package it.unicam.cs.platform;

import it.unicam.cs.model.User;

public abstract class UserFactory {
    public abstract User createUser(String name);
}
