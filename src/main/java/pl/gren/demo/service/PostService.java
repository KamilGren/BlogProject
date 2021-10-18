package pl.gren.demo.service;

import pl.gren.demo.dto.PostDto;
import pl.gren.demo.exception.PostNotFoundException;
import pl.gren.demo.model.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.gren.demo.repository.PostRepository;

import java.time.Instant;
import java.util.List;

import static java.util.stream.Collectors.toList;

@Service
public class PostService {

    PostRepository postRepository;

    @Autowired
    PostService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @Transactional
    public List<PostDto> showAllPosts() {
        List<Post> posts = postRepository.findAll();
        return posts.stream().map(this::mapFromPostToDto).collect(toList());
    }

    @Transactional
    public void deletePost(int id)
    {
        postRepository.deleteById(id);
    }

    @Transactional
    public void createPost(PostDto postDto) {
        Post post = mapFromDtoToPost(postDto);
        postRepository.save(post);
    }

    public List <Post> getPostByUserUsername(String username) { return postRepository.getPostByUser_Username(username); }


    @Transactional
    public PostDto readSinglePost(int id) {
        Post post = postRepository.findById(id).orElseThrow(() -> new PostNotFoundException("For id " + id));
        return mapFromPostToDto(post);
    }

    private PostDto mapFromPostToDto(Post post) {
        PostDto postDto = new PostDto();
        postDto.setId(post.getId());
        postDto.setTitle(post.getTitle());
        postDto.setContent(post.getContent());
        postDto.setUser(post.getUser());
        return postDto;
    }

    private Post mapFromDtoToPost(PostDto postDto) {
        Post post = new Post();
        post.setTitle(postDto.getTitle());
        post.setContent(postDto.getContent());
        //User loggedInUser = authService.getCurrentUser().orElseThrow(() -> new IllegalArgumentException("User Not Found"));
        post.setCreatedOn(Instant.now());
        //post.setUsername(loggedInUser.getUsername());
        post.setUpdatedOn(Instant.now());
        post.setUser(postDto.getUser());
        return post;
    }
}
