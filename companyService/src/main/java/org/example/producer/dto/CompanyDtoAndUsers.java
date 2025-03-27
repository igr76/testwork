package org.example.producer.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CompanyDtoAndUsers {

    private String name;

    private int budget;

    private List<UserDto> listUsers;
}
