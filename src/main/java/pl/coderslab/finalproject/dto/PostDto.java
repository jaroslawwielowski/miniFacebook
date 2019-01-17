package pl.coderslab.finalproject.dto;


import pl.coderslab.finalproject.entity.User;

import javax.validation.constraints.Max;

public class PostDto {


    private Long id;

    private String description;

    public PostDto() {
    }

    public PostDto(@Max(600) String description) {
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }



//    public User

}
