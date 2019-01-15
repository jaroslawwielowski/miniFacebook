package pl.coderslab.finalproject.entity;

import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Embeddable
//@Table(name = "friends")
public class Friend implements Serializable {


    @ManyToOne(fetch = FetchType.LAZY)
    @Column(name = "id_user_inviter")
    private Long idUserInviter;

//    @ManyToOne(fetch = FetchType.LAZY)
    @Column(name = "id_user_dusty")
    private Long idUserDusty;

    @CreationTimestamp
    private LocalDateTime createDateTime;

    private boolean accepted;

    public Friend() {
    }

    public LocalDateTime getCreateDateTime() {
        return createDateTime;
    }

    public void setCreateDateTime(LocalDateTime createDateTime) {
        this.createDateTime = createDateTime;
    }

    public Long getIdUserInviter() {
        return idUserInviter;
    }

    public void setIdUserInviter(Long idUserInviter) {
        this.idUserInviter = idUserInviter;
    }

    public Long getIdUserDusty() {
        return idUserDusty;
    }

    public void setIdUserDusty(Long idUserDusty) {
        this.idUserDusty = idUserDusty;
    }

    public boolean isAccepted() {
        return accepted;
    }

    public void setAccepted(boolean accepted) {
        this.accepted = accepted;
    }
}
