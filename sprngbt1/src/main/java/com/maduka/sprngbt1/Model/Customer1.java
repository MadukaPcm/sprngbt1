package com.maduka.sprngbt1.Model;

import jakarta.persistence.*;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Builder
@Entity(name = "customer1")
@Table
public class Customer1 {

    @Id
    @GeneratedValue
    private int id;
    private String name;

    @ManyToOne(cascade = CascadeType.ALL)    // Many customer have can have one item.
    @JoinColumn(name = "item1_id", referencedColumnName = "item1_id")
    private Item1 item1;
}

//https://medium.com/@bdamianchamel/relationships-in-spring-data-jpa-7c5ceaf05f29#:~:text=In%20Spring%20Data%20JPA%2C%20relationships%20between%20entities%20are%20established%20using,OneToOne%2C%20OneToMany%2C%20and%20ManyToMany.
// This is one Item have many customers.
