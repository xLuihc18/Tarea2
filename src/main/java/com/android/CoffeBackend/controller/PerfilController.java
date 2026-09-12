package com.android.CoffeBackend.controller;

import com.android.CoffeBackend.model.Usuario;
import com.android.CoffeBackend.service.PerfilService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/perfil")
@RequiredArgsConstructor
public class PerfilController {
    private final PerfilService perfilService;

    @GetMapping("/{id}")
    public ResponseEntity<Usuario> obtenerPerfil(@PathVariable Long id) {
        return ResponseEntity.ok(perfilService.obtenerPerfil(id));
    }
}
