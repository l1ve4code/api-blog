package ru.live4code.blog.api.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.live4code.blog.api.dto.RoleDTO;

import javax.persistence.EntityManager;

@RestController
@RequestMapping("/api/v1/admin")
public class AdminRestControllerV1 {

    @PostMapping("/role")
    public EntityManager createRole(@RequestBody RoleDTO roleDTO){
        return null;
    }

}
