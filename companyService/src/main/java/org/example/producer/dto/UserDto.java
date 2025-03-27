package org.example.producer.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {

    private Integer id;

    private int number;

    private String name;

    private String LastName;

    private int phone;

    @Override
    public String toString() {
        return "UserDto{" +
                "id=" + id +
                ", number=" + number +
                ", name='" + name + '\'' +
                ", LastName='" + LastName + '\'' +
                ", phone=" + phone +
                '}';
    }
}
