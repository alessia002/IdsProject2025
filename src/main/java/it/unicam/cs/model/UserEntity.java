package it.unicam.cs.model;

import it.unicam.cs.enums.Permission;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
public class UserEntity implements User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private List<Permission> permissions;

    @Override
    public List<Permission> getPermissions() {
        return permissions;
    }

    @Override
    public boolean hasPermission(Permission permission) {
        return permissions.contains(permission);
    }

}
