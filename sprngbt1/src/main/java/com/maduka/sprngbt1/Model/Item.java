package com.maduka.sprngbt1.Model;

import jakarta.persistence.*;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Builder
@Entity(name = "item")
@Table
public class Item {

    @Id
    @Column(name = "item_id")
    @GeneratedValue
    private int id;
    private String name;

    @OneToOne(cascade = CascadeType.ALL, mappedBy = "item")     // Owning side 'item' is the name of the variable of the owning side.
    private Customer customer;
}
