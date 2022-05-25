package ru.live4code.blog.api.dto;

import lombok.Data;
import ru.live4code.blog.data.role.Role;

@Data
public class RoleDTO {

    private String role;

    public static Role to(RoleDTO dto){
        Role role = new Role();
        role.setName(dto.getRole());
        return role;
    }

}
