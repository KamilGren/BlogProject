package pl.gren.demo.controller;

import pl.gren.demo.model.Post;
import pl.gren.demo.model.Role;
import pl.gren.demo.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import pl.gren.demo.service.PostService;
import pl.gren.demo.service.UserService;

import java.util.List;

@RestController
@CrossOrigin( origins = "*", maxAge = 3600)
public class UserController {

    private final UserService userService;
    private final PostService postService;

    @Autowired
    public UserController(UserService userService, PostService postService) {
        this.userService = userService;
        this.postService = postService;
    }

    @GetMapping("user/{Username}")
    ResponseEntity<User> readUsername(@PathVariable String Username) {

        return userService.findByName(Username)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("user/{Username}/roles")
    ResponseEntity<Role> readUsernameRole(@PathVariable String Username) {

        return ResponseEntity.ok(userService.findByName(Username).get().getRole());
    }

    @GetMapping("/users")
    ResponseEntity<List<User>> readAllUsers(Pageable pageable) {

        return ResponseEntity.ok(userService.listAll());
    }

    @GetMapping("/users/{username}/posts")
    ResponseEntity<List<Post>> readAllUserPosts(Pageable pageable, @PathVariable String username) {

        List<Post> lista = postService.getPostByUserUsername(username);
        //System.out.println(lista.get(0).getTitle());
        return ResponseEntity.ok(lista);
    }
}

