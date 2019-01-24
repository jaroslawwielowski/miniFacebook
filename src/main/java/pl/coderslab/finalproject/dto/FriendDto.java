package pl.coderslab.finalproject.dto;

import pl.coderslab.finalproject.entity.FriendId;

import java.util.Date;


public class FriendDto {



    private FriendId id;


    private UserDto user1;


    private UserDto user2;


    private Date createdOn = new Date();

    private boolean accepted;

    public FriendDto() {
    }



    public FriendId getId() {
        return id;
    }

    public void setId(FriendId id) {
        this.id = id;
    }

    public FriendDto(FriendId id, UserDto user1, UserDto user2, Date createdOn, boolean accepted) {
        this.id = id;
        this.user1 = user1;
        this.user2 = user2;
        this.createdOn = createdOn;
        this.accepted = accepted;
    }

    public UserDto getUser1() {
        return user1;
    }

    public void setUser1(UserDto user1) {
        this.user1 = user1;
    }

    public UserDto getUser2() {
        return user2;
    }

    public void setUser2(UserDto user2) {
        this.user2 = user2;
    }

    public Date getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(Date createdOn) {
        this.createdOn = createdOn;
    }

    public boolean isAccepted() {
        return accepted;
    }

    public void setAccepted(boolean accepted) {
        this.accepted = accepted;
    }
}
