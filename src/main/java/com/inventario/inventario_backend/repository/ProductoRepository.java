package com.inventario.inventario_backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.inventario.inventario_backend.model.Producto;

/*
*Spring Data JPA proporciona automáticamente implementaciones para:
*save(): guardar o actualizar productos, findById(): buscar producto por ID
*findAll(): obtener todos los productos, deleteById(): eliminar producto por ID
*/
public interface ProductoRepository extends JpaRepository<Producto, Long> {
}
