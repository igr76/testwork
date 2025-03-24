package org.example.consumer.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class UserEntity {
    @Id
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

    @Override
    public String toString() {
        return "UserEntity{" +
                "id=" + id +
                ", number=" + number +
                ", name='" + name + '\'' +
                ", LastName='" + LastName + '\'' +
                ", phone=" + phone +
                '}';
    }
}
