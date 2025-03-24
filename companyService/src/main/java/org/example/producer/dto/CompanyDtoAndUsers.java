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
    /**
     * name company
     */
    public String name;
    /**
     * budget company
     */
    public int budget;
    /**
     * List users company
     */
    public List<UserDto> listUsers;
}
