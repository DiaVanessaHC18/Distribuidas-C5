package com.example.ms_producto.service;

import com.example.ms_producto.entity.Producto;

import java.util.List;

public interface ProductoService {

    Producto guardar(Producto producto);

    List<Producto> listar();

    Producto buscarPorId(Long id);

    Producto actualizar(Long id, Producto producto);

    void eliminar(Long id);
}