package org.example.producer;


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
    public int id;
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
    @ElementCollection
    @CollectionTable(name = "list_user")
    public List<Integer> listUser;

}
