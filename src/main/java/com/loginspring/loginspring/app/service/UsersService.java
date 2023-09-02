package com.loginspring.loginspring.app.service;

import com.loginspring.loginspring.app.domain.entity.User;
import com.loginspring.loginspring.app.domain.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UsersService {

    @Autowired
    private UserRepository repository;

    public User saveUser(User user) {
        return repository.save(user);
    }

    public Optional<User> findByusername(String username) {
        return repository.findByUsername(username);
    }

}
