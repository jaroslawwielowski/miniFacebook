package pl.coderslab.finalproject.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name = "user_group")
public class UserGroup {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String groupName;

//    private List<Post> postList = new ArrayList<>();

    public UserGroup() {

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
//
//    public List<Post> getPostList() {
//        return postList;
//    }
//
//
//    public void setPostList(List<Post> postList) {
//        this.postList = postList;
//    }
}
