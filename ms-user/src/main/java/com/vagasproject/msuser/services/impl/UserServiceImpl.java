package com.vagasproject.msuser.services.impl;

import com.vagasproject.msuser.dto.UserRequest;
import com.vagasproject.msuser.entities.User;
import com.vagasproject.msuser.repositories.UserRepository;
import com.vagasproject.msuser.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    @Override
    @Transactional
    public User createUser(UserRequest userRequest) {
        User user = User.builder()
                .name(userRequest.getName())
                .email(userRequest.getEmail())
                .password(userRequest.getPassword())
                .resume(userRequest.getResume())
                .build();

        userRepository.save(user);
        return user;
    }
}
