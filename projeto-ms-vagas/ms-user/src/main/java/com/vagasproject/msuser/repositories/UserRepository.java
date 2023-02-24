package com.vagasproject.msuser.repositories;

import com.vagasproject.msuser.dto.UserRequest;
import com.vagasproject.msuser.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmail(String email);
}
