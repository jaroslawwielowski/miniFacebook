package pl.coderslab.finalproject.entity;

import javax.persistence.*;
import javax.validation.constraints.Max;

@Entity
@Table(name = "photos")
public class Photo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titlePhoto;

    @Max(600)
    @Column(columnDefinition = "TEXT")
    private String description;

    private byte[] profilePic;
}
