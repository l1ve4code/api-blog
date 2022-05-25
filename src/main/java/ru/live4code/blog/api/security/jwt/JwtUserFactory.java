package ru.live4code.blog.api.security.jwt;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import ru.live4code.blog.data.role.Role;
import ru.live4code.blog.data.user.User;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public final class JwtUserFactory {

    public JwtUserFactory() {}

    public static JwtUser create(User user){
        return new JwtUser(user.getId(), user.getSurname(), user.getName(), user.getUsername(), user.getEmail(), user.getPassword(), mapToGrantedAuthorities(new ArrayList<>(user.getRoles())));
    }

    private static List<GrantedAuthority> mapToGrantedAuthorities(List<Role> userRoles) {
        return userRoles.stream()
                .map(role ->
                        new SimpleGrantedAuthority(role.getName())
                ).collect(Collectors.toList());
    }

}
