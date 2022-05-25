package ru.live4code.blog.api.dao.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import ru.live4code.blog.api.dao.RoleDAO;
import ru.live4code.blog.api.dao.repository.RoleRepository;
import ru.live4code.blog.data.role.Role;

import java.util.List;

public class RoleDAOImpl implements RoleDAO {

    @Autowired
    private RoleRepository roleRepository;

    @Override
    public Role create(Role role) {
        roleRepository.save(role);
        return role;
    }

    @Override
    public Role delete(long id) {
        Role role = roleRepository.findById(id).orElse(null);
        if (role == null) return null;
        roleRepository.delete(role);
        return role;
    }

    @Override
    public List<Role> getAll() {
        List<Role> role = (List<Role>) roleRepository.findAll();
        return role;
    }

    @Override
    public Role findById(long id) {
        Role role = roleRepository.findById(id).orElse(null);
        if (role == null) return null;
        return role;
    }
}
