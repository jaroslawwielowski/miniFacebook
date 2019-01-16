//package pl.coderslab.finalproject.dto;
//
//import javax.persistence.*;
//import java.util.List;
//
//
//@Entity
//@Table(name = "user_group")
//public class UserGroup {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//
//    private String groupName;
//
//    @ManyToMany//(mappedBy = "usergroup")
//    private List<User> userList;
//
//    @OneToMany
//    private List<Post> postList;
//
//    public UserGroup() {
//
//    }
//
//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }
//
//    public String getGroupName() {
//        return groupName;
//    }
//
//    public void setGroupName(String groupName) {
//        this.groupName = groupName;
//    }
//
//    public List<User> getUserList() {
//        return userList;
//    }
//
//    public void setUserList(List<User> userList) {
//        this.userList = userList;
//    }
//
//    public List<Post> getPostList() {
//        return postList;
//    }
//
//    public void setPostList(List<Post> postList) {
//        this.postList = postList;
//    }
//}
