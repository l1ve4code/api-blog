package ru.live4code.blog.api.dao.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.live4code.blog.api.dao.RoleDAO;
import ru.live4code.blog.api.dao.repository.RoleRepository;
import ru.live4code.blog.data.role.Role;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Component
public class RoleDAOImpl implements RoleDAO {

    @Autowired
    private RoleRepository roleRepository;

    @Override
    public Role create(Role role) {
        role.setCreated_at(new Date());
        role.setUpdated_at(new Date());
        role.setUsers(new ArrayList<>());
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
