package pl.coderslab.finalproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.finalproject.entity.Photo;

public interface PhotoRepository extends JpaRepository<Photo, Long> {
}
