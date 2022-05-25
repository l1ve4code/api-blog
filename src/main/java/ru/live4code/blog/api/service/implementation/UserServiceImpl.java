package ru.live4code.blog.api.service.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.live4code.blog.api.dao.UserDAO;
import ru.live4code.blog.api.dto.UserDTO;
import ru.live4code.blog.api.service.UserService;
import ru.live4code.blog.data.user.User;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDAO userDAO;

    @Override
    public UserDTO register(User user) {
        return UserDTO.from(userDAO.register(user));
    }

    @Override
    public User delete(long id) {
        return userDAO.delete(id);
    }

    @Override
    public List<User> getAll() {
        return userDAO.getAll();
    }

    @Override
    public User findById(long id) {
        return userDAO.findById(id);
    }

    @Override
    public User findByUserName(String username) {
        return userDAO.findByUserName(username);
    }
}
