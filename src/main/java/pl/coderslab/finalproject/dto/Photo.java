package pl.coderslab.finalproject.dto;

import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import javax.validation.constraints.Max;
import java.time.LocalDateTime;

@Entity
@Table(name = "photos")
public class Photo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titlePhoto;

    @CreationTimestamp
    private LocalDateTime createDateTime;

    @Max(600)
    @Column(columnDefinition = "TEXT")
    private String description;

    private byte[] Picture;

    @ManyToOne
    @JoinColumn(name = "id_user")
    private User user;

    public Photo() {
    }

    public Photo(String titlePhoto, LocalDateTime createDateTime, @Max(600) String description, byte[] picture, User user) {
        this.titlePhoto = titlePhoto;
        this.createDateTime = createDateTime;
        this.description = description;
        Picture = picture;
        this.user = user;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitlePhoto() {
        return titlePhoto;
    }

    public void setTitlePhoto(String titlePhoto) {
        this.titlePhoto = titlePhoto;
    }

    public LocalDateTime getCreateDateTime() {
        return createDateTime;
    }

    public void setCreateDateTime(LocalDateTime createDateTime) {
        this.createDateTime = createDateTime;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public byte[] getPicture() {
        return Picture;
    }

    public void setPicture(byte[] picture) {
        Picture = picture;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
