package pl.coderslab.finalproject.dto;


import pl.coderslab.finalproject.entity.Post;
import pl.coderslab.finalproject.entity.UserGroup;

public class UserGroupDto {


    private Long id;

    private String groupName;


    public UserGroupDto() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }



    public UserGroup toDto(){
        UserGroup userGroup = new UserGroup();
        userGroup.setGroupName(groupName);
        return userGroup;
    }
}
