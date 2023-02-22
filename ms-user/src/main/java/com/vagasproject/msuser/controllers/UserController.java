package com.vagasproject.msuser.controllers;

import com.vagasproject.msuser.dto.UserRequest;
import com.vagasproject.msuser.dto.UserResponse;
import com.vagasproject.msuser.dto.UserUpdate;
import com.vagasproject.msuser.entities.User;
import com.vagasproject.msuser.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.lang.reflect.InvocationTargetException;
import java.net.URI;

@RestController
@RequestMapping("/api/user")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody UserRequest userRequest) {
        User newUser = userService.createUser(userRequest);

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequestUri()
                .path("/{id}")
                .buildAndExpand(newUser.getId())
                .toUri();

        return ResponseEntity.created(location).body(newUser);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserResponse> getUserById(@PathVariable Long id) {
        return ResponseEntity.ok(userService.getUserById(id));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<UserUpdate> partialUpdateUser(@PathVariable Long id, @RequestBody UserUpdate userUpdate) throws InvocationTargetException, IllegalAccessException {
        return ResponseEntity.ok(userService.partialUpdateUser(id, userUpdate));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
        return ResponseEntity.noContent().build();
    }
}
