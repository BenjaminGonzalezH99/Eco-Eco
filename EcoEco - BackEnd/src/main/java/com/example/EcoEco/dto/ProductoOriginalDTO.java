package com.example.EcoEco.dto;




import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;



import lombok.Data;


import java.time.LocalDateTime;
import java.util.List;

@Data

public class ProductoOriginalDTO {

    private long id;

    @NotBlank(message = "El nombre del producto es requerido")
    @Size(max = 50, message = "El nombre del producto no puede tener más de 255 caracteres")
    private String nombreProducto;

    @NotNull(message = "El stock del producto es requerido")
    private Integer stockProducto;

    @NotNull(message = "El precio del producto es requerido")
    private Double precioProducto;

    @NotBlank(message = "La descripción del producto es requerida")
    @Size(max = 255, message = "La descripción del producto no puede tener más de 255 caracteres")
    private String descripcionProducto;

    private LocalDateTime fechaCreacion;

    @NotNull(message = "La categoría del producto es requerida")
    private CategoriaDTO categoria;

    @NotNull(message = "Los productos alternativos son requeridos")
    private List<ProductoAlternativoDTO> alternativosProducto;

}