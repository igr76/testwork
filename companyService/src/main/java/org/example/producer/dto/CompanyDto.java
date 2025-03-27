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
public class CompanyDto {


    private String name;

    private int budget;

    private List<Integer> listUser;

    @Override
    public String toString() {
        return "CompanyDto{" +
                "name='" + name + '\'' +
                ", budget=" + budget +
                ", listUser=" + listUser +
                '}';
    }
}
