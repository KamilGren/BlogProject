package pl.gren.demo.repository;

import pl.gren.demo.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PostRepository extends JpaRepository<Post, Integer> {

    Optional<Post> findByTitle(String title);
    public List<Post> getPostByUser_Username(String username);
}
