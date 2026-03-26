package com.example.ms_producto.handler;

import com.example.ms_producto.exception.CategoriaNoEncontradaException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(CategoriaNoEncontradaException.class)
    public ResponseEntity<Map<String, String>> manejarCategoria(CategoriaNoEncontradaException ex) {

        Map<String, String> respuesta = new HashMap<>();
        respuesta.put("mensaje", ex.getMessage());

        return ResponseEntity.status(404).body(respuesta);
    }
}