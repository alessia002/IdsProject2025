package it.unicam.cs.model;

import it.unicam.cs.enums.Permission;
import java.util.List;

public interface User {
    List<Permission> getPermissions();
    boolean hasPermission(Permission permission);
}
