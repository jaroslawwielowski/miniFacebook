package pl.coderslab.finalproject.entity;

import javax.persistence.*;


@Entity
@Table(name = "groups")
public class Group {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
}
