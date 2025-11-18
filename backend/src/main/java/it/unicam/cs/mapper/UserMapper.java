package it.unicam.cs.mapper;

import it.unicam.cs.dto.UserDTO;
import it.unicam.cs.enums.Permission;
import it.unicam.cs.model.User;
import org.mapstruct.Mapper;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Mapper(componentModel = "spring")
public interface UserMapper {
    UserDTO toDTO(User entity);
    User toEntity(UserDTO dto);

    default String permissionsToString(List<Permission> permissions) {
        if (permissions == null || permissions.isEmpty()) {
            return null;
        }
        return permissions.stream()
                .map(Enum::name)
                .collect(Collectors.joining(","));
    }

    default List<Permission> stringToPermissions(String permissionsString) {
        if (permissionsString == null || permissionsString.isEmpty()) {
            return List.of();
        }
        return Stream.of(permissionsString.split(","))
                .map(String::trim)
                .map(Permission::valueOf)
                .collect(Collectors.toList());
    }

}




