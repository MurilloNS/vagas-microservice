package com.vagasproject.msuser.services.impl;

import com.vagasproject.msuser.components.NullAwareBeanUtilsBean;
import com.vagasproject.msuser.dto.UserRequest;
import com.vagasproject.msuser.dto.UserResponse;
import com.vagasproject.msuser.dto.UserUpdate;
import com.vagasproject.msuser.entities.User;
import com.vagasproject.msuser.repositories.UserRepository;
import com.vagasproject.msuser.services.UserService;
import com.vagasproject.msuser.services.exceptions.EmailAlreadyExist;
import com.vagasproject.msuser.services.exceptions.ObjectNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.lang.reflect.InvocationTargetException;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final NullAwareBeanUtilsBean beanUtilsBean;

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
        User user = userRepository.findById(id)
                .orElseThrow(() -> new ObjectNotFoundException(("Usuário não encontrado!")));
        return UserResponse.builder().name(user.getName()).email(user.getEmail()).resume(user.getResume()).build();
    }

    @Override
    @Transactional
    public UserUpdate partialUpdateUser(Long id, UserUpdate userUpdate) throws InvocationTargetException, IllegalAccessException {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new ObjectNotFoundException("Usuário não encontrado!"));
        beanUtilsBean.copyProperties(user, userUpdate);
        userRepository.save(user);
        return userUpdate;
    }

    @Override
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}
