package org.example.producer.entity;


import jakarta.persistence.CollectionTable;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
@Setter
@Getter
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class CompanyEntity {
    @Id
    private int id;

    private String name;

    private int budget;

    @ElementCollection
    @CollectionTable(name = "list_user")
    public List<Integer> listUser;

    @Override
    public String toString() {
        return "CompanyEntity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", budget=" + budget +
                ", listUser=" + listUser +
                '}';
    }
}
