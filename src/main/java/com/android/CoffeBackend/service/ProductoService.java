package com.android.CoffeBackend.service;

import com.android.CoffeBackend.dto.request.ProductoRequest;
import com.android.CoffeBackend.dto.response.ProductoResponse;
import com.android.CoffeBackend.model.Producto;
import com.android.CoffeBackend.repository.ProductoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProductoService {
    private final ProductoRepository productoRepository;

    public List<ProductoResponse> obtenerTodos() {
        return productoRepository.findAll().stream()
                .map(p -> ProductoResponse.builder()
                        .id(p.getId())
                        .nombre(p.getNombre())
                        .descripcion(p.getDescripcion())
                        .precio(p.getPrecio())
                        .categoria(p.getCategoria())
                        .imagenUrl(p.getImagenUrl())
                        .stock(p.getStock())
                        .build())
                .collect(Collectors.toList());
    }

    public ProductoResponse crear(ProductoRequest request) {
        Producto producto = new Producto();
        producto.setNombre(request.getNombre());
        producto.setDescripcion(request.getDescripcion());
        producto.setPrecio(request.getPrecio());
        producto.setCategoria(request.getCategoria());
        producto.setImagenUrl(request.getImagenUrl());
        producto.setStock(request.getStock());

        Producto guardado = productoRepository.save(producto);

        return ProductoResponse.builder()
                .id(guardado.getId())
                .nombre(guardado.getNombre())
                .descripcion(guardado.getDescripcion())
                .precio(guardado.getPrecio())
                .categoria(guardado.getCategoria())
                .imagenUrl(guardado.getImagenUrl())
                .stock(guardado.getStock())
                .build();
    }
}