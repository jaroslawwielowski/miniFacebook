package pl.coderslab.finalproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.finalproject.entity.UserDetail;

public interface UserDetailRepository extends JpaRepository<UserDetail, Long> {
}
