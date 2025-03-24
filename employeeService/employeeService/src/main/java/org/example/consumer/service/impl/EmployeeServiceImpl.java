package org.example.consumer.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.example.consumer.dto.UserMapper;
import org.example.consumer.dto.UserDto;
import org.example.consumer.entity.UserEntity;
import org.example.consumer.repository.UserRepositiry;
import org.example.consumer.service.EmployeeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Slf4j
@Service
public class EmployeeServiceImpl implements EmployeeService {

    private UserRepositiry userRepositiry;
    private UserMapper userMapper = new UserMapper();

    public EmployeeServiceImpl(UserRepositiry userRepositiry) {
        this.userRepositiry = userRepositiry;
    }

    @Override
    public UserDto getUserById(int id) {
        UserDto userDto = new UserDto();
        UserEntity userEntity = new UserEntity();
        try {
            userEntity = userRepositiry.findById(id).orElseThrow();
            log.debug(String.format("the employee by id=%s was successfully received"),id);
        } catch (Exception e) {
            log.error(e.getMessage());
        }
        userDto = userMapper.toDto(userEntity);
        return userDto;
    }

    @Override
    public List<UserDto> getAllUser() {
        List<UserDto> userDtos = new ArrayList<>();
        try {
            userDtos =userMapper.toListDto(userRepositiry.findAll());
            log.debug("the full list of employees has been successfully received");
        } catch (Exception e) {
            log.error(e.getMessage());
        }
        return userDtos;
    }

    @Override
    public UserDto getUserByname(String name) {
        UserDto userDto = new UserDto();
        UserEntity userEntity = new UserEntity();
        try {
            userEntity=userRepositiry.findByUsername(name).orElseThrow();
            log.debug(String.format("the employee by name=%s was successfully received"),name);
        } catch (Exception e) {
           log.error(e.getMessage());
        }
        userDto =  userMapper.toDto(userEntity);
        return userDto;
    }
}
