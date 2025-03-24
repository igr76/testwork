package org.example.consumer.dto;

import org.example.consumer.entity.UserEntity;

import java.util.ArrayList;
import java.util.List;

public class UserMapper {
    public UserEntity toEntity(UserDto userDto) {
        UserEntity userEntity = new UserEntity();
        userEntity.setId(userDto.getId());
        userEntity.setNumber(userDto.getNumber());
        userEntity.setName(userDto.getName());
        userEntity.setLastName(userDto.getLastName());
        userEntity.setPhone(userDto.getPhone());
        return userEntity;
    }
    public UserDto toDto(UserEntity userEntity) {
        UserDto userDto = new UserDto();
        userDto.setId(userEntity.getId());
        userDto.setNumber(userEntity.getNumber());
        userDto.setName(userEntity.getName());
        userDto.setLastName(userEntity.getLastName());
        userDto.setPhone(userEntity.getPhone());
        return userDto;
    }

    public List<UserDto> toListDto(List<UserEntity> all) {
        List<UserDto> userDtos = new ArrayList<>();
        for (UserEntity userEntity : all) {
            userDtos.add(toDto(userEntity));
        }
        return userDtos;
    }
}
