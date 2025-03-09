package org.example.consumer;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserService {
    UserRepositiry userRepositiry;
    UserMapper userMapper=new UserMapper();

    public UserService(UserRepositiry userRepositiry) {
        this.userRepositiry = userRepositiry;
    }

    public UserDto getUser(int id) {
        return userMapper.toDto(userRepositiry.findById(id).orElseThrow());
    }

    public List<UserDto> getAllUser() {
        return  userMapper.toListDto(userRepositiry.findAll());
    }

    public UserDto getUser(String name) {
        return userMapper.toDto(userRepositiry.findByUsername(name).orElseThrow());
    }
}
