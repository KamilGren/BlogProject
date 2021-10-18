package pl.gren.demo.service;

import pl.gren.demo.model.Comment;
import org.springframework.stereotype.Service;
import pl.gren.demo.repository.CommentRepository;

import java.util.List;

@Service
public class CommentService {

    private CommentRepository commentRepository;

    public CommentService(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

    public Comment save(Comment comment)
    {
        return commentRepository.save(comment);
    }

    public List<Comment> listAll() { return commentRepository.findAll(); }


}
