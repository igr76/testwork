package org.example.consumer.service;

import org.example.consumer.dto.UserDto;

import java.util.List;

public interface EmployeeService {
    UserDto getUserById(int id);

    List<UserDto> getAllUser();

    UserDto getUserByname(String name);
}
