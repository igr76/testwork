package org.example.consumer.service.impl;

import org.example.consumer.dto.UserMapper;
import org.example.consumer.dto.UserDto;
import org.example.consumer.repository.UserRepositiry;
import org.example.consumer.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    private static final Logger log = LoggerFactory.getLogger(UserServiceImpl.class);
    UserRepositiry userRepositiry;
    UserMapper userMapper = new UserMapper();

    public UserServiceImpl(UserRepositiry userRepositiry) {
        this.userRepositiry = userRepositiry;
    }

    @Override
    public UserDto getUserById(int id) {
        UserDto userDto = new UserDto();
        try {
            userDto = userMapper.toDto(userRepositiry.findById(id).orElseThrow());
            log.debug("getUserById:"+userDto.toString());
        } catch (Exception e) {
            log.error(e.getMessage());
        }
        return userDto;
    }

    @Override
    public List<UserDto> getAllUser() {
        List<UserDto> userDtos = new ArrayList<>();
        try {
            userDtos =userMapper.toListDto(userRepositiry.findAll());
            log.debug("getAllUser:"+userDtos.toString());
        } catch (Exception e) {
            log.error(e.getMessage());
        }
        return userDtos;
    }

    @Override
    public UserDto getUserByname(String name) {
        UserDto userDto = new UserDto();
        try {
            userDto =  userMapper.toDto(userRepositiry.findByUsername(name).orElseThrow());
            log.debug("getUserByname:"+userDto.toString());
        } catch (Exception e) {
           log.error(e.getMessage());
        }
        return userDto;
    }
}
