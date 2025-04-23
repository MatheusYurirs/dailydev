package br.com.yuri.dailydev.controller;

import br.com.yuri.dailydev.config.TokenService;
import br.com.yuri.dailydev.dto.request.LoginRequest;
import br.com.yuri.dailydev.dto.request.UserRequest;
import br.com.yuri.dailydev.dto.response.LoginResponse;
import br.com.yuri.dailydev.dto.response.UserResponse;
import br.com.yuri.dailydev.mapper.UserMapper;
import br.com.yuri.dailydev.model.User;
import br.com.yuri.dailydev.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/dailyentry/auth")
public class AuthController {

    private final UserService userService;
    private final AuthenticationManager authenticationManager;
    private final TokenService tokenService;

    public AuthController(UserService userService, AuthenticationManager authenticationManager, TokenService tokenService) {
        this.userService = userService;
        this.authenticationManager = authenticationManager;
        this.tokenService = tokenService;
    }

    @PostMapping("/register")
    public ResponseEntity<UserResponse> register(@RequestBody UserRequest request){
        System.out.println("Senha recebida no controller: " + request.password());
        User savedUser = userService.saveUser(UserMapper.toUser(request));
       return ResponseEntity.status(HttpStatus.CREATED).body(UserMapper.toUserResponse(savedUser));
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(@RequestBody LoginRequest request){
        UsernamePasswordAuthenticationToken usernamePass = new UsernamePasswordAuthenticationToken(request.email(),request.password());
        Authentication authenticate = authenticationManager.authenticate(usernamePass);

        User user = (User) authenticate.getPrincipal();

        String token = tokenService.generateToken(user);

        return ResponseEntity.ok(new LoginResponse(token));
    }
}
