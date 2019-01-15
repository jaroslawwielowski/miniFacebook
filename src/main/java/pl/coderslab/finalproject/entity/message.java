package pl.coderslab.finalproject.entity;

import javax.persistence.*;
import javax.validation.constraints.Max;


@Entity
@Table(name = "messages")
public class message {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Max(1600)
    @Column(columnDefinition = "TEXT")
    private String message;
}
