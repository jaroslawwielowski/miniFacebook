package pl.coderslab.finalproject.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;


@Entity
@Table(name = "friends")
public class Friend implements Serializable {



    @EmbeddedId
    private FriendId id;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("idUserInviter")
    private User user1;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("idUserDusty")
    private User user2;

    @Column(name = "created_on")
    private Date createdOn = new Date();

    private boolean accepted;

    public Friend() {
    }

    public Friend(User user1, User user2) {
        this.user1 = user1;
        this.user2 = user2;
        this.id = new FriendId(user1.getId(), user2.getId());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass())
            return false;

        Friend that = (Friend) o;
        return Objects.equals(user1, that.user1) &&
                Objects.equals(user2, that.user2);
    }

    @Override
    public int hashCode() {
        return Objects.hash(user1, user2);
    }

    public FriendId getId() {
        return id;
    }

    public void setId(FriendId id) {
        this.id = id;
    }

    public User getUser1() {
        return user1;
    }

    public void setUser1(User user1) {
        this.user1 = user1;
    }

    public User getUser2() {
        return user2;
    }

    public void setUser2(User user2) {
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
