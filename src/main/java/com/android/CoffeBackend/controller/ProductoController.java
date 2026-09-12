package com.android.CoffeBackend.controller;

import com.android.CoffeBackend.dto.request.ProductoRequest;
import com.android.CoffeBackend.dto.response.ProductoResponse;
import com.android.CoffeBackend.service.ProductoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/productos")
@RequiredArgsConstructor
public class ProductoController {
    private final ProductoService productoService;

    @GetMapping
    public ResponseEntity<List<ProductoResponse>> obtenerTodos() {
        return ResponseEntity.ok(productoService.obtenerTodos());
    }

    @PostMapping
    public ResponseEntity<ProductoResponse> crear(@RequestBody ProductoRequest request) {
        return ResponseEntity.ok(productoService.crear(request));
    }
}