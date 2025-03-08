package org.example.consumer;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {

    public int id;
    /**
     * number user
     */
    public int number;
    /**
     * name user
     */
    public String name;
    /**
     * Last name user
     */
    public String LastName;
    /**
     * phone number user
     */
    public int phone;
}
