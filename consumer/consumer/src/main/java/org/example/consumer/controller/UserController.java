package org.example.consumer.controller;

import lombok.NoArgsConstructor;
import lombok.NonNull;
import org.antlr.v4.runtime.misc.NotNull;
import org.example.consumer.service.UserService;
import org.example.consumer.dto.UserDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/user")
public class UserController {

    UserService userService;

    @GetMapping(value = "/{id}")
    public ResponseEntity<UserDto> getUser(@PathVariable(value = "id") int id) {
        return ResponseEntity.ok(userService.getUserById(id));
    }
    @GetMapping(value = "/{name}")
    public ResponseEntity<UserDto> getUser(@PathVariable(value = "name")@NonNull String name) {
        return ResponseEntity.ok(userService.getUserByname(name));
    }

    @GetMapping(value = "/all")
    public ResponseEntity<List<UserDto>> getAllUser() {
        return ResponseEntity.ok (userService.getAllUser());
    }
}
