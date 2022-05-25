package ru.live4code.blog.api.dao;

import ru.live4code.blog.data.role.Role;

import java.util.List;

public interface RoleDAO {
    Role create(Role role);
    Role delete(long id);
    List<Role> getAll();
    Role findById(long id);
}
