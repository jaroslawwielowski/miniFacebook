package pl.coderslab.finalproject.dto;


import javax.validation.constraints.Max;
import java.time.LocalDateTime;


public class PhotoDto {


    private Long id;

    private String titlePhoto;

    private LocalDateTime createDateTime;


    private String description;

    private byte[] Picture;



    public PhotoDto() {
    }

    public PhotoDto(String titlePhoto, LocalDateTime createDateTime, @Max(600) String description, byte[] picture) {
        this.titlePhoto = titlePhoto;
        this.createDateTime = createDateTime;
        this.description = description;
        Picture = picture;
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


}
