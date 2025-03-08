package org.example.consumer;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    UserService userService;

    @GetMapping(value = "/{id}")
    public ResponseEntity<UserDto> getUser(@PathVariable(value = "id") Integer id) {
        return ResponseEntity.ok(userService.getUser(id));
    }

    @GetMapping(value = "/all")
    public ResponseEntity<List<UserDto>> getAllUser() {
        return ResponseEntity.ok (userService.getAllUser());
    }
}
