package com.example.EcoEco.models;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "categorias")
@Data
@NoArgsConstructor
public class Categoria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_categoria")
    private long idCategoria;

    @Column(name="Cat_nombre")
    private String nombreCategoria;

    @OneToMany(mappedBy = "categoria")
    private List<ProductoOriginal> productos;
}
