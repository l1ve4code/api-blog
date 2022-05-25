package ru.live4code.blog.api.service.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.live4code.blog.api.dao.RoleDAO;
import ru.live4code.blog.api.service.RoleService;
import ru.live4code.blog.data.role.Role;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleDAO roleDAO;

    @Override
    public Role create(Role role) {
        return roleDAO.create(role);
    }

    @Override
    public Role delete(long id) {
        return roleDAO.delete(id);
    }

    @Override
    public List<Role> getAll() {
        return roleDAO.getAll();
    }

    @Override
    public Role findById(long id) {
        return roleDAO.findById(id);
    }
}
