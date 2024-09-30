package com.maduka.sprngbt1.Model.relationship;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "drivers")
@NoArgsConstructor
@Getter
@Setter
public class Driver {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false, updatable = false)
    private String name;

    @OneToOne(
            // a car will only be retrieved from the database when
            // it is explicitly accessed
            fetch = FetchType.LAZY,
            // you must specify a Car before you save the Driver
            optional = false,
            // all save/persist operations will be propagated
            // through to the Car
            cascade = CascadeType.PERSIST
    )
    @JoinColumn(name = "car_id", nullable = false)  // Custom foreign key column name
    private Car car;
}


//driver1.setCar(car2);
//car2.setDriver(driver3);
