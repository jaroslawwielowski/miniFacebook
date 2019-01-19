package pl.coderslab.finalproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.finalproject.entity.Friend;
import pl.coderslab.finalproject.entity.Post;
import pl.coderslab.finalproject.entity.User;
import pl.coderslab.finalproject.entity.UserGroup;

import java.util.List;

public interface PostRepository extends JpaRepository<Post, Long> {

    public List<Post> getAllByUserAndUser_Friends(User user, List<User> user_friends);

//    public List<Post> getAllByUserAndUser_FriendsAscCreateDateTime()
    public  List<Post> getPostsByUser(List<User> users);
    public List<Post> getPostsByUserGroup(UserGroup userGroup);
}
