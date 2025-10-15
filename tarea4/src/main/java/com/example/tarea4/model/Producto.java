package com.example.tarea4.model;

import jakarta.persistence.*;
import lombok.*;


@Entity
@Table (name = "productos")
public class Producto {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_producto")
    private int idProducto;
    private String nombre;
    private String categoria;
    private String marca;
    private String unidadMedida;
    private int precio;
    private String estado;

    public int getIdProducto() {
        return idProducto;
    }

    public String getNombre() {
        return nombre;
    }

    public String getCategoria() {
        return categoria;
    }

    public String getMarca() {
        return marca;
    }

    public String getUnidadMedida() {
        return unidadMedida;
    }

    public int getPrecio() {
        return precio;
    }

    public String getEstado() {
        return estado;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public void setUnidadMedida(String unidadMedida) {
        this.unidadMedida = unidadMedida;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Producto() {
    }

    public Producto(int idProducto, String nombre, String categoria, String marca, String unidadMedida, int precio, String estado) {
        this.idProducto = idProducto;
        this.nombre = nombre;
        this.categoria = categoria;
        this.marca = marca;
        this.unidadMedida = unidadMedida;
        this.precio = precio;
        this.estado = estado;
    }
}
