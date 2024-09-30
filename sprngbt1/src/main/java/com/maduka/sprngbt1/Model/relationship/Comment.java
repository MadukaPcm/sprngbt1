package com.maduka.sprngbt1.Model.relationship;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Comment {

    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false, updatable = false)
    private String username;

    @Column(nullable = false)
    private String content;

    @ManyToOne(
            cascade = CascadeType.ALL,
            optional = false,
            fetch = FetchType.LAZY
    )
    @JoinColumn(name = "post_id") // foreign key column in the 'comments' table
    private Post post;
}


//// correct approach
//// setting the relationship on the owning-side
//comment.setPost(post);
//saveComment(comment);
//
//// instead of
//post.getComments().add(post);
//savePost(post);
