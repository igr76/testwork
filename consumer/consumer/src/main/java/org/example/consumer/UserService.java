package org.example.consumer;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserService {
    UserRepositiry userRepositiry;
    UserMapper userMapper;
//    Map<Integer, UserDto> usersMap = new HashMap<>();
    public UserDto getUser(int id) {
        return userMapper.toDto(userRepositiry.findById(id).orElseThrow());
    }

    public List<UserDto> getAllUser() {
        return  userMapper.toListDto(userRepositiry.findAll());
    }
}
