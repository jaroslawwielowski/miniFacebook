package pl.coderslab.finalproject.entity;

import javax.persistence.*;


@Entity
@Table(name = "messages")
public class message {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
}
