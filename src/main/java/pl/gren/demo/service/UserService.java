package pl.gren.demo.service;

import pl.gren.demo.model.User;
import org.springframework.stereotype.Service;
import pl.gren.demo.repository.UserRepository;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> listAll() { return userRepository.findAll(); }

    public Optional<User> findByName(String userName) { return userRepository.findByUsername(userName); }
}
