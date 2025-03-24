package org.example.consumer.controller;

import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;
import org.example.consumer.service.EmployeeService;
import org.example.consumer.dto.UserDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@Slf4j
@RestController
@RequestMapping(path = "/user")
public class UserController {

    private  EmployeeService userService;

    @GetMapping(value = "/{id}")
    public ResponseEntity<UserDto> getUser(@PathVariable(value = "id") int id) {
        log.debug(String.format("In UserController getUser for id=%s  received successfully"),id);
        return ResponseEntity.ok(userService.getUserById(id));
    }
    @GetMapping(value = "/{name}")
    public ResponseEntity<UserDto> getUser(@PathVariable(value = "name")@NonNull String name) {
        log.debug(String.format("In UserController getUser for name=%s  received successfully"),name);
        return ResponseEntity.ok(userService.getUserByname(name));
    }

    @GetMapping(value = "/all")
    public ResponseEntity<List<UserDto>> getAllUser() {
        log.debug("In UserController getAllUser launched");
        return ResponseEntity.ok (userService.getAllUser());
    }
}
