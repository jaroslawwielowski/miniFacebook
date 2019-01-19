package pl.coderslab.finalproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.finalproject.entity.Friend;
import pl.coderslab.finalproject.entity.User;

import java.util.List;

public interface FriendRepository extends JpaRepository<Friend, Long> {

//    public List<User> getFriendsByUser1AndUser2(User user);

}
