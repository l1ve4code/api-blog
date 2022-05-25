package ru.live4code.blog.api.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.live4code.blog.api.dto.AuthDTO;
import ru.live4code.blog.api.dto.RoleDTO;
import ru.live4code.blog.api.dto.UserDTO;
import ru.live4code.blog.api.security.jwt.JwtTokenProvider;
import ru.live4code.blog.api.service.RoleService;
import ru.live4code.blog.api.service.UserService;
import ru.live4code.blog.data.role.Role;
import ru.live4code.blog.data.user.User;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@RestController
@RequestMapping("/api/v1/auth")
public class AuthRestControllerV1 {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtTokenProvider jwtTokenProvider;

    @Autowired
    private UserService userService;

    @Autowired
    private RoleService roleService;

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody AuthDTO authDTO){
        try {
            String username = authDTO.getUsername();
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, authDTO.getPassword()));
            User user = userService.findByUserName(username);

            if(user == null) throw new UsernameNotFoundException("User with username: " + username + ", not found!");

            String token = jwtTokenProvider.createToken(username, user.getRoles());

            Map<Object, Object> response = new HashMap<>();
            response.put("username", user.getUsername());
            response.put("token", token);

            return ResponseEntity.ok(response);
        }
        catch (AuthenticationException e){
            throw new BadCredentialsException("Invalid username or password");
        }
    }

    @PostMapping("/register")
    public ResponseEntity register(@RequestBody UserDTO userDTO){
        try {
            User user = UserDTO.to(userDTO);
            UserDTO isRegistered = userService.register(user);
            if (isRegistered == null) throw new BadCredentialsException("User with username: " + user.getUsername() + ", not registered!");
            return ResponseEntity.ok(isRegistered);
        }
        catch (Exception e){
            throw new BadCredentialsException("Invalid username or password");
        }
    }

//    @PostMapping("/role")
//    public ResponseEntity role(@RequestBody RoleDTO roleDTO){
//        Role role = roleService.create(RoleDTO.to(roleDTO));
//        return ResponseEntity.ok(role);
//    }

}
