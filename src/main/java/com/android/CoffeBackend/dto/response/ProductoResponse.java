package com.android.CoffeBackend.dto.response;

import lombok.Builder;
import lombok.Data;
import java.math.BigDecimal;

@Data
@Builder
public class ProductoResponse {
    private Long id;
    private String nombre;
    private String descripcion;
    private BigDecimal precio;
    private String categoria;
    private String imagenUrl;
    private Integer stock;
}