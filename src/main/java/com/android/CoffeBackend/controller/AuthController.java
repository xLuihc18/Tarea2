package com.android.CoffeBackend.controller;

import com.android.CoffeBackend.dto.request.LoginRequest;
import com.android.CoffeBackend.dto.request.RegistroRequest;
import com.android.CoffeBackend.dto.response.AuthResponse;
import com.android.CoffeBackend.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {
    private final AuthService authService;

    @PostMapping("/registro")
    public ResponseEntity<AuthResponse> registrar(@RequestBody RegistroRequest request) {
        return ResponseEntity.ok(authService.registrar(request));
    }

    @PostMapping("/login")
    public ResponseEntity<AuthResponse> login(@RequestBody LoginRequest request) {
        return ResponseEntity.ok(authService.login(request));
    }
}