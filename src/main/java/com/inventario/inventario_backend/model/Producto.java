package com.inventario.inventario_backend.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

// Esta es una entidad JPA que representa un producto en la base de datos
@Entity
// Especifica que esta entidad se mapea a la tabla "productos" en la BD
@Table(name = "productos")
public class Producto {

    // ID único del producto, es la clave primaria
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Este ID se genera automáticamente por la base de datos 
    private Long id;

    private String nombre;
    private String categoria;
    private double precio;
    private int cantidad;

    public Long getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getCategoria() {
        return categoria;
    }

    public double getPrecio() {
        return precio;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
}
