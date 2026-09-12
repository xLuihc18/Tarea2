package com.android.CoffeBackend.dto.request;

import lombok.Data;
import java.math.BigDecimal;

@Data
public class ProductoRequest {
    private String nombre;
    private String descripcion;
    private BigDecimal precio;
    private String categoria;
    private String imagenUrl;
    private Integer stock;
}