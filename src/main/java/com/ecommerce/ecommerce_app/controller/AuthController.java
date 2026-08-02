package com.ecommerce.ecommerce_app.controller;

import com.ecommerce.ecommerce_app.dto.LoginRequest;
import com.ecommerce.ecommerce_app.dto.LoginResponse;
import com.ecommerce.ecommerce_app.model.User;
import com.ecommerce.ecommerce_app.security.JwtService;
import com.ecommerce.ecommerce_app.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final UserService userService;
    private final JwtService jwtService;
    private final PasswordEncoder passwordEncoder;

    public AuthController(UserService userService, JwtService jwtService, PasswordEncoder passwordEncoder) {
        this.userService = userService;
        this.jwtService = jwtService;
        this.passwordEncoder = passwordEncoder;
    }

    @PostMapping("/register")
    public User register(@RequestBody User user) {
        return userService.registerUser(user.getUsername(), user.getEmail(), user.getPassword());
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(@RequestBody LoginRequest loginRequest){
        User user =userService.findByUsername(loginRequest.getUsername());
        if (user == null) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
        boolean passwordMatches = passwordEncoder.matches(loginRequest.getPassword(), user.getPassword());

        if (!passwordMatches) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
        // get role enum getiriyor onu to stringle stringe çevirdik.
        String token = jwtService.generateToken(user.getUsername(),user.getRole().toString());

        return ResponseEntity.ok(new LoginResponse(token));
    }
}