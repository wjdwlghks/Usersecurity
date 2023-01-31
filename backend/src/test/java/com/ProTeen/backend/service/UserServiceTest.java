package com.ProTeen.backend.service;

import com.ProTeen.backend.entity.User;
import com.ProTeen.backend.repository.UserRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;
import java.util.Collection;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class UserServiceTest {

    @Autowired
    private UserService userService;

    @Autowired
    private UserRepository userRepository;

    private final PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    @Test()
    @DisplayName("create에서 user가 null인 경우")
    void create_1() {
        User user = null;
        Throwable exception = assertThrows(RuntimeException.class, () -> {
            userService.create(user);
        });
        assertEquals("Invalid arguments", exception.getMessage());
    }

    @Test()
    @DisplayName("create에서 userId가 null인 경우")
    void create_2() {
        User user = User.builder().build();
        Throwable exception = assertThrows(RuntimeException.class, () -> {
            userService.create(user);
        });
        assertEquals("Invalid arguments", exception.getMessage());
    }

    @Test()
    @DisplayName("DB에 해당 userId가 이미 존재하는 경우")
    void create_3() {
        User user = User.builder()
                .id("1")
                .createdDate("2023-01-16 14:23:00")
                .nickname("Kim")
                .role("ROLE_ADMIN")
                .userId("aaaa")
                .userPassword("qwe123")
                .build();

        Throwable exception = assertThrows(RuntimeException.class, () -> {
            userService.create(user);
        });
        assertEquals("This userId already exists", exception.getMessage());
    }

    @Test
    @DisplayName("userId가 DB에 없는 경우")
    void getBycredentials_1() {
        String userId = "cccc";
        String userPassword = "1234";
        User user = userService.getBycredentials(
                userId,
                userPassword,
                passwordEncoder
        );
        assertNull(user);
    }

    @Test
    @DisplayName("비밀번호 다를 때")
    void getBycredentials_2() {
        String userId = "test";
        // 실제로는 1234
        String userPassword = "12345";
        User user = userService.getBycredentials(
                userId,
                userPassword,
                passwordEncoder
        );
        assertNull(user);
    }

    @Test
    @DisplayName("비밀번호 같을 때")
    void getBycredentials_3() {
        String userId = "test";
        String userPassword = "1234";
        User expected = userService.getBycredentials(
                userId,
                userPassword,
                passwordEncoder
        );

        User actual = User.builder()
                .id("ff8081818602ce02018602ce7f810000")
                .createdDate("2023-01-30 22:12:12")
                .nickname("test")
                .role("ROLE_USER")
                .userId("test")
                .userPassword("$2a$10$FvnPpJMwZkskSBl7NsWuqeF3beYjWsAwHTwg9RjxWNHLhVXdJLWR2")
                .build();

        assertEquals(expected.toString(), actual.toString());

    }

    @Test
    @DisplayName("DB에서 role 조회하기")
    void getAuthorities() {
        String id = "ff8081818602ce02018602ce7f810000";
        Collection<? extends GrantedAuthority> expected = userService.getAuthorities(id);
        Collection<SimpleGrantedAuthority> actual = new ArrayList<>();
        actual.add(new SimpleGrantedAuthority("ROLE_USER"));

        assertEquals(expected, actual);

    }
}
