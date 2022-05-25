package ru.live4code.blog.data.role;

import lombok.Data;
import ru.live4code.blog.data.user.User;
import ru.live4code.blog.data.util.UniqueFields;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "roles")
public class Role extends UniqueFields {

    @Column(name = "name")
    private String name;

    @ManyToMany(mappedBy = "roles", fetch = FetchType.LAZY)
    private List<User> users;

}
