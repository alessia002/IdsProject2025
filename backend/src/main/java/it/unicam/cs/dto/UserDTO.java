package it.unicam.cs.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO
{
    private String username;
    private String password;
    private String roles;
    private String permissions;
}
