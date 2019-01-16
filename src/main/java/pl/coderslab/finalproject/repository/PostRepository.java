package pl.coderslab.finalproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.finalproject.entity.Post;

public interface PostRepository extends JpaRepository<Post, Long> {
}
