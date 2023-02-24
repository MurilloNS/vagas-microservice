package com.vagasproject.msuser.services;

import com.vagasproject.msuser.dto.UserRequest;
import com.vagasproject.msuser.dto.UserResponse;
import com.vagasproject.msuser.dto.UserUpdate;
import com.vagasproject.msuser.entities.User;

import java.lang.reflect.InvocationTargetException;

public interface UserService {
    User createUser(UserRequest userRequest);

    UserResponse getUserById(Long id);

    UserUpdate partialUpdateUser(Long id, UserUpdate userUpdate) throws InvocationTargetException, IllegalAccessException;

    void deleteUser(Long id);
}
