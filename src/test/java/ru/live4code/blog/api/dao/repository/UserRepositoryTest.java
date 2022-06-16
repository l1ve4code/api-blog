package ru.live4code.blog.api.dao.repository;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import ru.live4code.blog.data.user.User;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class UserRepositoryTest {

    private static long USER_ID = 1L;

    @Autowired
    private UserRepository underTest;

//    @AfterEach
//    void tearDown() {
//        underTest.deleteAll();
//    }

    @Test
    void itShouldFindUserByUsername(){

        User user = new User();
        user.setId(USER_ID);
        user.setSurname("Vedenin");
        user.setName("Ivan");
        user.setEmail("steven.marelly@gmail.com");
        user.setUsername("live4code");
        user.setPassword("SimplePassword");

        underTest.save(user);

        User finded = underTest.findByUsername(user.getUsername());

        assertThat(finded).isEqualTo(user);

    }

}