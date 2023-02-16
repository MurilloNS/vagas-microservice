package com.vagasproject.msuser.services;

import com.vagasproject.msuser.dto.UserRequest;
import com.vagasproject.msuser.entities.User;

public interface UserService {
    User createUser(UserRequest userRequest);
}
