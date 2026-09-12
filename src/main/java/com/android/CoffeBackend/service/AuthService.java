package com.android.CoffeBackend.service;

import com.android.CoffeBackend.dto.request.LoginRequest;
import com.android.CoffeBackend.dto.request.RegistroRequest;
import com.android.CoffeBackend.dto.response.AuthResponse;
import com.android.CoffeBackend.model.Usuario;
import com.android.CoffeBackend.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {
    private final UsuarioRepository usuarioRepository;

    public AuthResponse registrar(RegistroRequest request) {
        if (usuarioRepository.existsByEmail(request.getEmail())) {
            throw new RuntimeException("El email ya está registrado");
        }

        Usuario usuario = new Usuario();
        usuario.setNombre(request.getNombre());
        usuario.setApellido(request.getApellido());
        usuario.setEmail(request.getEmail());
        usuario.setPassword(request.getPassword());
        usuario.setUbicacion(request.getUbicacion());
        usuario.setDni(request.getDni());
        usuario.setTelefono(request.getTelefono());

        usuarioRepository.save(usuario);

        return new AuthResponse(usuario.getId(), usuario.getEmail(), "Registro exitoso");
    }

    public AuthResponse login(LoginRequest request) {
        Usuario usuario = usuarioRepository.findByEmail(request.getEmail())
                .orElseThrow(() -> new RuntimeException("Credenciales inválidas"));

        if (!request.getPassword().equals(usuario.getPassword())) {
            throw new RuntimeException("Credenciales inválidas");
        }

        return new AuthResponse(usuario.getId(), usuario.getEmail(), "Login exitoso");
    }
}
