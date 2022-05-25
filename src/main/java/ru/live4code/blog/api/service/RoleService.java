package ru.live4code.blog.api.service;

import ru.live4code.blog.data.role.Role;

import java.util.List;

public interface RoleService {
    Role create(Role role);
    Role delete(long id);
    List<Role> getAll();
    Role findById(long id);
}
