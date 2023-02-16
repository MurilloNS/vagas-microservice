package com.vagasproject.msuser.repositories;

import com.vagasproject.msuser.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
