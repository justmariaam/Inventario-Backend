package com.inventario.inventario_backend.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.inventario.inventario_backend.model.Producto;
import com.inventario.inventario_backend.service.ProductoService;

@RestController
@RequestMapping("/api/productos")
@CrossOrigin(origins = "*")
public class ProductoController {

    private final ProductoService service;

    public ProductoController(ProductoService service) {
        this.service = service;
    }

    // GET - listar productos
    @GetMapping
    public List<Producto> listar() {
        return service.listar();
    }

    // GET - obtener uno por ID
    @GetMapping("/{id}")
    public Producto obtener(@PathVariable Long id) {
        return service.obtenerPorId(id);
    }

    // POST - crear producto
    @PostMapping
    public Producto crear(@RequestBody Producto p) {
        return service.guardar(p);
    }

    // PUT - actualizar producto
    @PutMapping("/{id}")
    public Producto actualizar(@PathVariable Long id, @RequestBody Producto p) {
        p.setId(id);
        return service.guardar(p);
    }

    // DELETE - eliminar producto
    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        service.eliminar(id);
    }
}
