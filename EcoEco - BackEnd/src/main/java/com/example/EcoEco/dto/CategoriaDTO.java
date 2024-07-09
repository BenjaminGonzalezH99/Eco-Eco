package com.example.EcoEco.dto;



import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;



@Data

public class CategoriaDTO {

    private Long id;

    @NotBlank(message = "El nombre de la categoría es requerido")
    @Size(min = 3, max = 50, message = "El nombre de la categoría debe tener entre 3 y 50 caracteres")
    private String nombre;
}