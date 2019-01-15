package pl.coderslab.finalproject.entity;

import javax.persistence.*;
import javax.validation.constraints.Max;

@Entity
@Table(name = "posts")
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Max(600)
    @Column(columnDefinition = "TEXT")
    private String description;
}
