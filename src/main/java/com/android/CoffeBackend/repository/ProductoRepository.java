package com.android.CoffeBackend.repository;

import com.android.CoffeBackend.model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductoRepository extends JpaRepository<Producto, Long> {
}
