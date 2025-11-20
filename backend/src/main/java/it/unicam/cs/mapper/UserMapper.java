package it.unicam.cs.mapper;

import it.unicam.cs.dto.UserDTO;
import it.unicam.cs.enums.Role;
import it.unicam.cs.model.User;
import org.mapstruct.Mapper;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Mapper(componentModel = "spring")
public interface UserMapper {
    UserDTO toDTO(User entity);
    User toEntity(UserDTO dto);

    default String rolesToString(List<Role> roles) {
        if (roles == null || roles.isEmpty()) {
            return null;
        }
        return roles.stream()
                .map(Enum::name)
                .collect(Collectors.joining(","));
    }

    default List<Role> stringToRoles(String rolesString) {
        if (rolesString == null || rolesString.isEmpty()) {
            return List.of();
        }
        return Stream.of(rolesString.split(","))
                .map(String::trim)
                .map(Role::valueOf)
                .collect(Collectors.toList());
    }

}




