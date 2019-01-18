package pl.coderslab.finalproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.coderslab.finalproject.entity.User;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    public User getUserByConfirmationId(String confirmationId);

    public User getUserByEmail(String email);

    public User getUserByConfirmationOnlineId(String confirmationOnlineId);

    public User getUserById(Long id);

    public List<User> getUsersByFriends(User user);
}
