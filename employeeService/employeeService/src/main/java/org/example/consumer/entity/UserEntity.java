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
    private int id;

    private int number;

    private String name;

    private String LastName;

    private int phone;

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
