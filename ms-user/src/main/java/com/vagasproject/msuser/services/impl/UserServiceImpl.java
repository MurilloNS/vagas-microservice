package com.vagasproject.msuser.services.impl;

import com.vagasproject.msuser.dto.UserRequest;
import com.vagasproject.msuser.dto.UserResponse;
import com.vagasproject.msuser.dto.UserUpdate;
import com.vagasproject.msuser.entities.User;
import com.vagasproject.msuser.repositories.UserRepository;
import com.vagasproject.msuser.services.UserService;
import com.vagasproject.msuser.services.exceptions.EmailAlreadyExist;
import com.vagasproject.msuser.services.exceptions.ObjectNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import javax.persistence.EntityNotFoundException;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    @Override
    @Transactional
    public User createUser(UserRequest userRequest) {
        if (userRepository.findByEmail(userRequest.getEmail()) == null) {
            User user = User.builder()
                    .name(userRequest.getName()).email(userRequest.getEmail()).password(userRequest.getPassword())
                    .resume(userRequest.getResume()).build();

            userRepository.save(user);
            return user;
        } else {
            throw new EmailAlreadyExist("Esse e-mail já está cadastrado!");
        }
    }

    @Override
    public UserResponse getUserById(Long id) {
        try {
            User user = userRepository.findById(id).get();
            UserResponse result = UserResponse.builder().name(user.getName()).email(user.getEmail())
                    .resume(user.getResume()).build();

            return result;
        } catch (NoSuchElementException e) {
            throw new ObjectNotFoundException("Usuário não encontrado!");
        }
    }

    @Override
    public UserUpdate partialUpdateUser(Long id, UserUpdate userUpdate) {
        try {
            User user = userRepository.findById(id).get();
            user.setName(userUpdate.getName());
            user.setPassword(userUpdate.getPassword());
            user.setResume(userUpdate.getResume());
            userRepository.save(user);
            return userUpdate;
        } catch (NoSuchElementException e) {
            throw new ObjectNotFoundException("Usuário não encontrado!");
        }
    }
}
