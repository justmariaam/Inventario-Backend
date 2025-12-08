package com.inventario.inventario_backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.inventario.inventario_backend.model.Producto;

public interface ProductoRepository extends JpaRepository<Producto, Long> {
}
