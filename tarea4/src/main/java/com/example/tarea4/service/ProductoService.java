package com.example.tarea4.service;
import com.example.tarea4.model.Producto;
import java.util.*;

public interface ProductoService {

    List<Producto> getAllProductos();

    Optional<Producto> getProductoById(int id);

    Producto createProducto(Producto Producto);

    Optional<Producto> updateProducto(int id, Producto Producto);

    boolean deleteProducto(int id);
}
