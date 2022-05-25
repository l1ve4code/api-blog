package ru.live4code.blog.api.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ru.live4code.blog.api.security.jwt.JwtUser;
import ru.live4code.blog.api.security.jwt.JwtUserFactory;
import ru.live4code.blog.api.service.UserService;
import ru.live4code.blog.data.user.User;

@Service
public class JwtUserDetailService implements UserDetailsService {

    @Autowired
    private UserService userService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userService.findByUserName(username);

        if (user == null) throw new UsernameNotFoundException("User with username: " + username + ", not found! [ERROR 404]");

        JwtUser jwtUser = JwtUserFactory.create(user);

        return jwtUser;
    }

}
