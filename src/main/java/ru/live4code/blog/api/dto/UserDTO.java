package ru.live4code.blog.api.dto;

import lombok.Data;
import ru.live4code.blog.data.user.User;

import javax.persistence.Column;
import java.util.List;
import java.util.stream.Collectors;

@Data
public class UserDTO {

    private String surname;

    private String name;

    private String username;

    private String email;

    private String password;

    private List<String> role_name;

    public static UserDTO from(User user){
        UserDTO dto = new UserDTO();
        dto.setSurname(user.getSurname());
        dto.setName(user.getName());
        dto.setUsername(user.getUsername());
        dto.setEmail(user.getEmail());
        dto.setPassword(user.getPassword());
        dto.setRole_name(user.getRoles().stream().map(RoleDTO::parseName).collect(Collectors.toList()));
        return dto;
    }

    public static User to(UserDTO dto){

        User user = new User();

        user.setSurname(dto.getSurname());
        user.setName(dto.getName());
        user.setUsername(dto.getUsername());
        user.setEmail(dto.getEmail());
        user.setPassword(dto.getPassword());

        return user;
    }

}
