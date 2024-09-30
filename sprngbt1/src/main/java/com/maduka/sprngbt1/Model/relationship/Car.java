package com.maduka.sprngbt1.Model.relationship;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "cars")
@NoArgsConstructor
@Getter
@Setter
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String brand;

    @Column(name = "horsepower")
    private int horsepower;

    // note that the annotation and field are new
    @OneToOne(
            // indicates that this is the child side of a
            // relationship and refers to the field in the Driver
            // class that defines the relationship there
            mappedBy = "car"
    )
    private Driver driver;
}


//driver1.setCar(car2);
//car2.setDriver(driver3);
