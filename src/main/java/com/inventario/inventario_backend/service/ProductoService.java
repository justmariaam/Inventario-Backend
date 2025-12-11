package com.inventario.inventario_backend.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.inventario.inventario_backend.model.Producto;
import com.inventario.inventario_backend.repository.ProductoRepository;

@Service
public class ProductoService {

    // Repositorio para acceder a la base de datos
    private final ProductoRepository repo;

    public ProductoService(ProductoRepository repo) {
        this.repo = repo;
    }

    // Obtener todos los productos
    public List<Producto> listar() {
        return repo.findAll();
    }

    // Guardar producto (crear o actualizar)
    public Producto guardar(Producto p) {
        return repo.save(p);
    }

    // Buscar producto por ID
    public Producto obtenerPorId(Long id) {
        return repo.findById(id).orElse(null);
    }

    // Eliminar producto por ID
    public void eliminar(Long id) {
        repo.deleteById(id);
    }
}
