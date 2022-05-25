package ru.live4code.blog.api.dao.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;
import ru.live4code.blog.api.dao.UserDAO;
import ru.live4code.blog.api.dao.repository.RoleRepository;
import ru.live4code.blog.api.dao.repository.UserRepository;
import ru.live4code.blog.data.role.Role;
import ru.live4code.blog.data.user.User;

import java.util.List;

@Component
public class UserDAOImpl implements UserDAO {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Override
    public User register(User user) {
        user.setRoles((List<Role>) roleRepository.findByName("USER"));
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }

    @Override
    public User delete(long id) {
        User user = userRepository.findById(id).orElse(null);
        if (user == null) return null;
        userRepository.delete(user);
        return user;
    }

    @Override
    public List<User> getAll() {
        List<User> user = (List<User>) userRepository.findAll();
        return user;
    }

    @Override
    public User findById(long id) {
        User user = userRepository.findById(id).orElse(null);
        if (user == null) return null;
        return user;
    }

    @Override
    public User findByUserName(String username) {
        User user = userRepository.findByUsername(username);
        return user;
    }
}
