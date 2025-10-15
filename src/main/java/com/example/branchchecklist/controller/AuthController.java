package com.example.branchchecklist.controller;

import com.example.branchchecklist.dto.AuthRequest;
import com.example.branchchecklist.dto.AuthResponse;
import com.example.branchchecklist.model.User;
import com.example.branchchecklist.service.JwtService;
import com.example.branchchecklist.service.UserService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final JwtService jwtService;
    private final UserService userService;

    public AuthController(JwtService jwtService, UserService userService) {
        this.jwtService = jwtService;
        this.userService = userService;
    }

    @PostMapping("/token")
    public AuthResponse getToken(@RequestBody AuthRequest request) {
        // Ensure user exists (create if not)
        userService.createIfNotExists(request.getMobile());
        // Generate token
        String token = jwtService.generateToken(request.getMobile());
        return new AuthResponse(token);
    }
}
