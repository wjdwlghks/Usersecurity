package com.ProTeen.backend.repository;


import com.ProTeen.backend.entity.User;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
public class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;


    @Test
    @DisplayName("userId로 User 조회하기")
    void findByUserId() {
        String userId = "aaaa";
        User expected = userRepository.findByUserId(userId);
        User actual = User.builder()
                .id("1")
                .createdDate("2023-01-16 14:23:00")
                .nickname("Kim")
                .role("ROLE_ADMIN")
                .userId("aaaa")
                .userPassword("qwe123")
                .build();

        assertEquals(expected.toString(), actual.toString());
    }

    @Test
    @DisplayName("해당 userId 존재하는지")
    void existsByUserId() {
        String userId = "aaaa";
        Boolean expected = userRepository.existsByUserId(userId);
        Boolean actual = true;

        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Id로 role 조회하기")
    void getRoleById() {
        String userId = "2";
        String expected = userRepository.getRoleById(userId);
        String actual = "ROLE_USER";

        assertEquals(expected, actual);
    }
}
