package com.example.ms_producto.client;


import com.example.ms_producto.dto.CategoriaDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "categoria-service", url = "http://localhost:8080")
public interface CategoriaClient {

    @GetMapping("/categoria/{id}")
    CategoriaDTO obtenerCategoria(@PathVariable Long id);
}