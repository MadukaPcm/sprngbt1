package com.maduka.sprngbt1.Model.relationship;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.*;

import javax.xml.stream.events.Comment;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Post {

    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false, updatable = false)
    private String username;

    @Column(nullable = false)
    private String content;

    // this annotation references the configuration
    // on the post field in the Comment class
    @OneToMany(mappedBy = "post")  // mappedBy attribute on the non-owning side to indicate that the relationship is controlled by the other entity.
    private List<Comment> comments;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<Location> locations;
}

//// correct approach
//// setting the relationship on the owning-side
//comment.setPost(post);
//saveComment(comment);
//
//// instead of
//post.getComments().add(post);
//savePost(post);
