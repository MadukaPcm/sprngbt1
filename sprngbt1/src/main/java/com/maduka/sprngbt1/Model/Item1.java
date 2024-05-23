package com.maduka.sprngbt1.Model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Builder
@Entity(name = "item1")
@Table
public class Item1 {

    @Id
    @Column(name = "item1_id")
    @GeneratedValue
    private int id;
    private String name;

    @OneToMany(mappedBy = "item1")   // Telling the table that this relationship is handled by customer1 table on item1 field.
    private List<Customer1> customer1;

}

//https://medium.com/@bdamianchamel/relationships-in-spring-data-jpa-7c5ceaf05f29#:~:text=In%20Spring%20Data%20JPA%2C%20relationships%20between%20entities%20are%20established%20using,OneToOne%2C%20OneToMany%2C%20and%20ManyToMany.
//This is one item can have many customers.

//@OneToMany(mappedBy = "parent")
//private Collection<Category> children;
