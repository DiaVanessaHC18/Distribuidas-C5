package com.example.ms_producto.service.impl;

import com.example.ms_producto.client.CategoriaClient;
import com.example.ms_producto.dto.CategoriaDTO;
import com.example.ms_producto.entity.Producto;
import com.example.ms_producto.exception.CategoriaNoEncontradaException;
import com.example.ms_producto.repository.ProductoRepository;
import com.example.ms_producto.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductoServiceImpl implements ProductoService {

    @Autowired
    private CategoriaClient categoriaClient;

    @Autowired
    private ProductoRepository repository;

    @Override
    public Producto guardar(Producto producto) {

        try {
            CategoriaDTO categoria = categoriaClient.obtenerCategoria(producto.getIdCategoria());
        } catch (Exception e) {
            throw new CategoriaNoEncontradaException("Categoría inexistente");
        }

        return repository.save(producto);
    }

    @Override
    public List<Producto> listar() {
        return repository.findAll();
    }

    @Override
    public Producto buscarPorId(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Producto no encontrado"));
    }

    @Override
    public Producto actualizar(Long id, Producto producto) {

        Producto existente = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Producto no encontrado"));

        try {
            categoriaClient.obtenerCategoria(producto.getIdCategoria());
        } catch (Exception e) {
            throw new CategoriaNoEncontradaException("Categoría inexistente");
        }
        existente.setNombre(producto.getNombre());
        existente.setIdCategoria(producto.getIdCategoria());

        return repository.save(existente);
    }

    @Override
    public void eliminar(Long id) {

        Producto existente = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Producto no encontrado"));

        repository.delete(existente);
    }
}