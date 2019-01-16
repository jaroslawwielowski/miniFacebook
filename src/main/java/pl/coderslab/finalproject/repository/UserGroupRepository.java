package pl.coderslab.finalproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.finalproject.entity.User;
import pl.coderslab.finalproject.entity.UserGroup;

public interface UserGroupRepository extends JpaRepository<UserGroup, Long> {
}
