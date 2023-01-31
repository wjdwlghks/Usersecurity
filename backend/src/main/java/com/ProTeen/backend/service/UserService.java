package com.ProTeen.backend.service;


import com.ProTeen.backend.entity.User;
import com.ProTeen.backend.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;

@Slf4j
@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User create(final User user) {
        if (user == null || user.getUserId() == null) {
            throw new RuntimeException("Invalid arguments");
        }
        final String userId = user.getUserId();
        if (userRepository.existsByUserId(userId)) {
            log.warn("This userId already exists {}", userId);
            throw new RuntimeException("This userId already exists");
        }
        return userRepository.save(user);
    }

    public User getBycredentials(final String userId, final String userPassword, final PasswordEncoder encoder) {
        final User originalUser = userRepository.findByUserId(userId);
        // matches 메서드를 이용해 패스워드가 같은지 확인
        if (originalUser != null && encoder.matches(userPassword, originalUser.getUserPassword())) {
            return originalUser;
        }
        return null;
    }

    public Collection<? extends GrantedAuthority> getAuthorities(String id) {
        String role = userRepository.getRoleById(id);
        log.info("role : " + role + " userId : " + id);
        Collection<SimpleGrantedAuthority> authority = new ArrayList<>();
        authority.add(new SimpleGrantedAuthority(role));
        return authority;
    }
}
