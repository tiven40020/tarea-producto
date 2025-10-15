package com.example.tarea4.service;
import com.example.tarea4.model.Producto;
import com.example.tarea4.repository.ProductoRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ProductoServiceImpl implements ProductoService{

    private final ProductoRepository productoRepository;

    public ProductoServiceImpl(ProductoRepository productoRepository) {
        this.productoRepository = productoRepository;
    }

    @Override
    public List<Producto> getAllProductos() {
        return productoRepository.findAll();
    }

    @Override
    public Optional<Producto> getProductoById(int id) {
        return productoRepository.findById(id);
    }

    @Override
    public Producto createProducto(Producto producto) {
        return productoRepository.save(producto);
    }


    @Override
    public Optional<Producto> updateProducto(int id, Producto producto) {
        Optional<Producto> productoExistente = productoRepository.findById(id);

        if (productoExistente.isPresent()) {
            Producto aux = productoExistente.get();

            if (producto.getNombre() != null && !producto.getNombre().isBlank()) {
                aux.setNombre(producto.getNombre());
            }
            if (producto.getCategoria() != null && !producto.getCategoria().isBlank()) {
                aux.setCategoria(producto.getCategoria());
            }
            if (producto.getMarca() != null && !producto.getMarca().isBlank()) {
                aux.setMarca(producto.getMarca());
            }
            if (producto.getUnidadMedida() != null && !producto.getUnidadMedida().isBlank()) {
                aux.setUnidadMedida(producto.getUnidadMedida());
            }
            if (producto.getPrecio() > 0) {
                aux.setPrecio(producto.getPrecio());
            }
            if (producto.getEstado() != null && !producto.getEstado().isBlank()) {
                aux.setEstado(producto.getEstado());
            }
            Producto actualizado = productoRepository.save(aux);
            return Optional.of(actualizado);
        }
        return Optional.empty();
    }

    @Override
    public boolean deleteProducto(int id) {
        if(productoRepository.existsById(id)){
            productoRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
