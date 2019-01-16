package pl.coderslab.finalproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.finalproject.entity.Messages;

public interface MessagesRepository extends JpaRepository<Messages, Long> {
}
