package com.maduka.sprngbt1.Model;

import jakarta.persistence.*;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Builder
@Entity(name = "customer")
@Table
public class Customer {

    @Id
    @GeneratedValue
    private int id;
    private String name;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "item_id", referencedColumnName = "item_id")
    private Item item;
}

//https://www.tutorialspoint.com/jpa/jpa_entity_relationships.htm Nzuri jata jpa relationship.