package com.example.ms_producto.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "producto")
public class Producto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;

    private Long idCategoria;
}
