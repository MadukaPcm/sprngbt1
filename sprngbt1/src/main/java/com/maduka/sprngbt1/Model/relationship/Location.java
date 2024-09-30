package com.maduka.sprngbt1.Model.relationship;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Location {

    @Id
    @GeneratedValue
    private Long id;

    @Column
    private String name;

    @Column(nullable = false)
    private Long latitude;

    @Column(nullable = false)
    private Long longitude;

    // this annotation refers to the
    // locations field in the Post class
    @ManyToMany(mappedBy = "locations")   // mappedBy attribute on the non-owning side to indicate that the relationship is controlled by the other entity.
    private List<Post> posts;
}

