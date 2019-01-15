package pl.coderslab.finalproject.entity;

import javax.persistence.*;

@Entity
@Table(name = "friends")
public class Friend {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long idUserInviter;

    private Long idUserDusty;

    private boolean accepted;
}
