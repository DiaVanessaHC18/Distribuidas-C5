package com.example.ms_producto.controller;

import com.example.ms_producto.entity.Producto;
import com.example.ms_producto.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/productos")
public class ProductoController {

    @Autowired
    private ProductoService service;

    @PostMapping
    public ResponseEntity<Producto> crear(@RequestBody Producto producto) {
        return ResponseEntity.ok(service.guardar(producto));
    }

    @GetMapping
    public ResponseEntity<List<Producto>> listar() {
        return ResponseEntity.ok(service.listar());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Producto> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(service.buscarPorId(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Producto> actualizar(@PathVariable Long id,
                                               @RequestBody Producto producto) {
        return ResponseEntity.ok(service.actualizar(id, producto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminar(@PathVariable Long id) {
        service.eliminar(id);
        return ResponseEntity.ok("Producto eliminado correctamente");
    }
}