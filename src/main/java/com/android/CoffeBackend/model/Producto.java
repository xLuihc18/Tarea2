package com.android.CoffeBackend.model;

import jakarta.persistence.*;
import lombok.Data;
import java.math.BigDecimal;

@Entity
@Table(name = "producto")
@Data
public class Producto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nombre;

    private String descripcion;

    @Column(nullable = false)
    private BigDecimal precio;

    private String categoria;
    private String imagenUrl;
    private Integer stock;
}