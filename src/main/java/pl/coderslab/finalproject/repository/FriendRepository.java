package pl.coderslab.finalproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.finalproject.entity.Friend;

public interface FriendRepository extends JpaRepository<Friend, Long> {
}
