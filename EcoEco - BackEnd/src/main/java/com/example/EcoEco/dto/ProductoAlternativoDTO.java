package com.example.EcoEco.dto;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import lombok.Data;


import java.time.LocalDateTime;

@Data

public class ProductoAlternativoDTO {

    private long id;

    @NotBlank(message = "El nombre del producto alternativo es requerido")
    @Size(max = 50, message = "El nombre del producto alternativo no puede tener más de 255 caracteres")
    private String nombre;

    @NotNull(message = "La durabilidad del producto alternativo es requerida")
    private int durabilidad;

    @NotBlank(message = "La descripción del producto alternativo es requerida")
    @Size(max = 255, message = "La descripción del producto alternativo no puede tener más de 255 caracteres")
    private String descripcion;

    @NotNull(message = "El precio del producto alternativo es requerido")
    private Double precioProducto;

    private LocalDateTime fechaCreacion;

    @NotNull(message = "El producto original es requerido")
    private ProductoOriginalDTO productoOriginal;

}