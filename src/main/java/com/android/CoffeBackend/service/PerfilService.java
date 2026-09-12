package com.android.CoffeBackend.service;

import com.android.CoffeBackend.model.Usuario;
import com.android.CoffeBackend.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PerfilService {
    private final UsuarioRepository usuarioRepository;

    public Usuario obtenerPerfil(Long usuarioId) {
        return usuarioRepository.findById(usuarioId)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
    }
}
