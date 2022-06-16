package ru.live4code.blog.api.dao.repository;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import ru.live4code.blog.api.dao.repository.RoleRepository;
import ru.live4code.blog.data.role.Role;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@DataJpaTest
class RoleRepositoryTest {

    @Autowired
    private RoleRepository underTest;

    @AfterEach
    void tearDown() {
        underTest.deleteAll();
    }

    @Test
    void isShouldFindRoleByName(){

        //given
        Role role = new Role();
        role.setName("ROLE_USER");

        underTest.save(role);

        //when
        Role finded = underTest.findByName(role.getName());

        //then
        assertThat(finded).isEqualTo(role);

    }

}
