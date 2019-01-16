//package pl.coderslab.finalproject.dto;
//
//
//import javax.persistence.Column;
//import javax.persistence.Embeddable;
//import java.io.Serializable;
//import java.util.Objects;
//
//public class FriendId implements Serializable {
//
//    @Column(name = "id_user_inviter")
//    private Long idUserInviter;
//
//    @Column(name = "id_user_dusty")
//    private Long idUserDusty;
//
//
//
//    public FriendId() {
//    }
//
//    public FriendId(Long idUserInviter, Long idUserDusty) {
//        this.idUserInviter = idUserInviter;
//        this.idUserDusty = idUserDusty;
//    }
//
//
//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//
//        if (o == null || getClass() != o.getClass())
//            return false;
//
//        FriendId that = (FriendId) o;
//        return Objects.equals(idUserDusty, that.idUserDusty) &&
//                Objects.equals(idUserInviter, that.idUserInviter);
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(idUserDusty, idUserInviter);
//    }
//
//    public Long getIdUserInviter() {
//        return idUserInviter;
//    }
//
//    public void setIdUserInviter(Long idUserInviter) {
//        this.idUserInviter = idUserInviter;
//    }
//
//    public Long getIdUserDusty() {
//        return idUserDusty;
//    }
//
//    public void setIdUserDusty(Long idUserDusty) {
//        this.idUserDusty = idUserDusty;
//    }
//}
