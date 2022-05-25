package ru.live4code.blog.api.service;

import ru.live4code.blog.data.user.User;

import java.util.List;

public interface UserService {
    User register(User user);
    User delete(long id);
    List<User> getAll();
    User findById(long id);
    User findByUserName(String username);
}
