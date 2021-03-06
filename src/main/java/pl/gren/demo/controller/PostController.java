package pl.gren.demo.controller;

import pl.gren.demo.dto.PostDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.gren.demo.service.PostService;

import java.util.List;

@RestController
@RequestMapping("/api/posts")
@CrossOrigin( origins = "*", maxAge = 3600)
public class PostController {

    @Autowired
    private PostService postService;

    @PostMapping
    public ResponseEntity createPost(@RequestBody PostDto postDto) {
        postService.createPost(postDto);
        System.out.println("kamil" + postDto);
        return new ResponseEntity(HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<List<PostDto>> showAllPosts() {
        return new ResponseEntity<>(postService.showAllPosts(), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<PostDto>> showText() {
        System.out.println("Ja działam");
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<PostDto> getSinglePost(@PathVariable @RequestBody int id) {
        return new ResponseEntity<>(postService.readSinglePost(id), HttpStatus.OK);
    }

}
