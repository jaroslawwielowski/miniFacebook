package pl.coderslab.finalproject.entity;


import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import java.time.LocalDateTime;
import java.util.*;

import org.hibernate.annotations.NaturalIdCache;
import org.mindrot.jbcrypt.BCrypt;


import static javax.persistence.CascadeType.ALL;

@Entity
@Table(name = "users")
@NaturalIdCache
@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @CreationTimestamp
    private LocalDateTime createDateTime;
    @NotBlank
    @NotEmpty
    private String firstName;
    @NotBlank
    @NotEmpty
    private String lastName;
    @NotBlank
    @NotEmpty
    @Email(regexp = ".+")
    @Column(unique=true)
    private String email;
    @NotEmpty
//    @Size(min = 2, max = 30, message = "hasło musi posiadac od 2 do 30 znaków")
    private String password;
    @OneToOne(fetch = FetchType.EAGER, cascade = ALL)
    @JoinColumn(name = "id_userDetails")
    private UserDetail userDetails;

    private String administrativeRights;

    private boolean confirmationStatus;
    private String confirmationId;

    private String confirmationOnlineId;
    private boolean online;

    @OneToOne
    @JoinColumn(name = "id_profile_pic")
    private Photo profilePic;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)//mappedBy = "user",
    private List<Friend> friends = new ArrayList<>();

    @JoinTable(name = "users_groups", joinColumns = @JoinColumn(name = "id_user"),
            inverseJoinColumns = @JoinColumn(name = "id_group"))
    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<UserGroup> userGroupList;


    @OneToMany(cascade = CascadeType.ALL)//mappedBy = "user",
    private List<Post> postList = new ArrayList<>();


    public List<Post> getPostList() {
        return postList;
    }

    public void setPostList(List<Post> postList) {
        this.postList = postList;
    }

    public List<UserGroup> getUserGroupList() {
        return userGroupList;
    }

    public void setUserGroupList(List<UserGroup> userGroupList) {
        this.userGroupList = userGroupList;
    }

    public Photo getProfilePic() {
        return profilePic;
    }

    public void setProfilePic(Photo profilePic) {
        this.profilePic = profilePic;
    }

    public List<Friend> getFriends() {
        return friends;
    }

    public void setFriends(List<Friend> friends) {
        this.friends = friends;

    }

    public User(@NotBlank @NotEmpty String firstName) {
        this.firstName = firstName;
    }

    public void setPassword(String password) {
        // NOTE w przypadku gdy hasło jest pustym stringiem/nullem, funkcja hashpw zadziała i wygeneruje
        // nie-nullowego hasha
        // chcemy tego uniknąć:)
        this.password =
                password == null || password.isEmpty()
                        ? password
                        : BCrypt.hashpw(password, BCrypt.gensalt());
    }

    public boolean passwordMatches(String plainTextPassword) {
        return BCrypt.checkpw(plainTextPassword, this.password);
    }

    public String getConfirmationOnlineId() {
        return confirmationOnlineId;
    }

    public void setConfirmationOnlineId(String confirmationOnlineId) {
        this.confirmationOnlineId = confirmationOnlineId;
    }


    public boolean isOnline() {
        return online;
    }

    public void setOnline(boolean online) {
        this.online = online;
    }

    public UserDetail getUserDetails() {
        return userDetails;
    }

    public void setUserDetails(UserDetail userDetails) {
        this.userDetails = userDetails;
    }

    public boolean isConfirmationStatus() {
        return confirmationStatus;
    }

    public void setConfirmationStatus(boolean confirmationStatus) {
        this.confirmationStatus = confirmationStatus;
    }

    public String getConfirmationId() {
        return confirmationId;
    }

    public void setConfirmationId(String confirmationId) {
        this.confirmationId = confirmationId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getCreateDateTime() {
        return createDateTime;
    }

    public void setCreateDateTime(LocalDateTime createDateTime) {
        this.createDateTime = createDateTime;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }



    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", createDateTime=" + createDateTime +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(firstName, user.firstName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName);
    }

    public String getAdministrativeRights() {
        return administrativeRights;
    }

    public void setAdministrativeRights(String administrativeRights) {
        this.administrativeRights = administrativeRights;
    }
}
