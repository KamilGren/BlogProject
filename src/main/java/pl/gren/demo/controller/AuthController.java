package pl.gren.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.gren.demo.dto.LoginRequest;
import pl.gren.demo.dto.RegisterRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import pl.gren.demo.service.AuthService;

import javax.validation.constraints.NotBlank;

@Controller
@CrossOrigin( origins = "*", maxAge = 3600)
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    AuthService authService;

    @PostMapping("/signup")
    public ResponseEntity signup(@RequestBody @NotBlank RegisterRequest registerRequest) {
            authService.signup(registerRequest);
            return new ResponseEntity(HttpStatus.OK);
    }

    @PostMapping("/login")
    public String login(@RequestBody LoginRequest loginRequest) {
        return authService.login(loginRequest);
    }


}
