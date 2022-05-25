package ru.live4code.blog.api.dto;

import lombok.Data;
import ru.live4code.blog.data.role.Role;

@Data
public class RoleDTO {

    private String name;

    public static String parseName(Role role){
        String name = role.getName();
        return name;
    }

    public static RoleDTO from(Role role){
        RoleDTO dto = new RoleDTO();
        dto.setName(role.getName());
        return dto;
    }

    public static Role to(RoleDTO dto){
        Role role = new Role();
        role.setName(dto.getName());
        return role;
    }

}
