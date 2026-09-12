package com.android.CoffeBackend.dto.request;

import lombok.Data;

@Data
public class RegistroRequest {
    private String nombre;
    private String apellido;
    private String email;
    private String password;
    private String ubicacion;
    private String dni;
    private String telefono;
}