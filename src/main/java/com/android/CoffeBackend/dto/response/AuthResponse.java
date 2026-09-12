package com.android.CoffeBackend.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AuthResponse {
    private Long usuarioId;
    private String email;
    private String mensaje;
}