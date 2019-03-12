package com.fiberhome.pwd.security.controller;

import com.fiberhome.pwd.security.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {

    @Value("${jwt.header: Authorization}")
    private String tokenHeader;

    @Autowired
    private AuthService authService;

    @PostMapping("/login")
    public Object createAuthenticationToken(String username, String password) {
        final String token = authService.login(username, password);
        return token;
    }

}
