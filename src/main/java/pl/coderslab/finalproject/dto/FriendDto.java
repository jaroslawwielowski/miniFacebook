//package pl.coderslab.finalproject.dto;
//
//import javax.persistence.*;
//import java.io.Serializable;
//import java.util.Date;
//import java.util.Objects;
//
//
//public class Friend implements Serializable {
//
//
//
//    @EmbeddedId
//    private FriendId id;
//
//
//    private User user1;
//
//
//    private User user2;
//
//
//    private Date createdOn = new Date();
//
//    private boolean accepted;
//
//    public Friend() {
//    }
//
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(user1, user2);
//    }
//
//    public FriendId getId() {
//        return id;
//    }
//
//    public void setId(FriendId id) {
//        this.id = id;
//    }
//
//    public User getUser1() {
//        return user1;
//    }
//
//    public void setUser1(User user1) {
//        this.user1 = user1;
//    }
//
//    public User getUser2() {
//        return user2;
//    }
//
//    public void setUser2(User user2) {
//        this.user2 = user2;
//    }
//
//    public Date getCreatedOn() {
//        return createdOn;
//    }
//
//    public void setCreatedOn(Date createdOn) {
//        this.createdOn = createdOn;
//    }
//
//    public boolean isAccepted() {
//        return accepted;
//    }
//
//    public void setAccepted(boolean accepted) {
//        this.accepted = accepted;
//    }
//}
